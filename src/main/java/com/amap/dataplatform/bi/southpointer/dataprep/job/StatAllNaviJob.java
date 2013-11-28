package com.amap.dataplatform.bi.southpointer.dataprep.job;

import java.io.IOException;
import java.net.URI;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobPriority;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import com.amap.dataplatform.bi.common.ConstantsParseDate;
import com.amap.dataplatform.bi.common.ConstantsParseInput;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatAosCarRouteMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatBusRouteMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatNaviAutoMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatNaviBusMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatWalkRouteMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.reduce.StatAllNaviReducer;
import com.amap.dataplatform.bi.southpointer.dataprep.reduce.StatAosCarRouteReducer;

public class StatAllNaviJob extends Configured implements Tool{
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new StatAllNaviJob(),  args);
		System.out.println(exitCode);
	}

	public int run(String[] args) throws Exception {
		
		// read job conf from xml 
		Configuration conf = new Configuration();
		conf.addResource("configuration.xml");
		conf.set("mapred.job.queue.name", "amap"); 
		conf.set("mapred.queue.name","amap");
		conf.set("mapred.job.priority", JobPriority.VERY_HIGH.toString());
		conf.set("mapred.textoutputformat.separatorText", ",");
		
		//parse date , get/set job prefix
		Date date = new Date();
		
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
		String dateString = "";
		if (0 != otherArgs.length && 1 != otherArgs.length) { 
			
			
			System.exit(-1); 
			
		} else if (0 == otherArgs.length) {
			
			// current date
			conf.set("InputDate", dateString);
			
		} else if (1 == otherArgs.length) {
			
			dateString = otherArgs[0];
			conf.set("InputDate", dateString);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			try {				
				date = simpleDateFormat.parse(dateString);
			} catch (ParseException e) {
				try {
					simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					date = simpleDateFormat.parse(dateString);
				} catch (ParseException pe) {
					pe.printStackTrace();
					System.out.println("ERROR.Parameter 'date' can not be parsed. Please check it.");
					System.exit(-2);
				}
			}
			
		}
		
		
		Job job = new Job(conf,"stat_allnavi_job"+ConstantsParseDate.outputDate(date));
	 	job.setJarByClass(StatAllNaviJob.class);
    	job.setReducerClass(StatAllNaviReducer.class);
    	job.setMapOutputKeyClass(Text.class);
    	job.setMapOutputValueClass(Text.class);
    	job.setOutputKeyClass(Text.class);
    	job.setOutputValueClass(NullWritable.class);
    	job.setNumReduceTasks(4);
    	
    	String aosbusrouPathString = conf.get("mapred.job.loadaosbusroujob.input.datapath.template", "");
		if ("".equalsIgnoreCase(aosbusrouPathString)) {
			System.exit(-3);
		}
		aosbusrouPathString = ConstantsParseDate.parseDay(aosbusrouPathString, date);
		
		
		String aoswalkrouPathString = conf.get("mapred.job.loadaoswalkroujob.input.datapath.template", "");
		if ("".equalsIgnoreCase(aoswalkrouPathString)) {
			System.exit(-3);
		}
		aoswalkrouPathString = ConstantsParseDate.parseDay(aoswalkrouPathString, date);
		
		String wsnaviautoPathString = conf.get("mapred.job.loadwsnaviautojob.input.datapath.template", "");
		if ("".equalsIgnoreCase(wsnaviautoPathString)) {
			
			System.exit(-3);
		}
		wsnaviautoPathString = ConstantsParseDate.parseDay(wsnaviautoPathString, date);
		
		String wsnavibusPathString = conf.get("mapred.job.loadwsnavibusjob.input.datapath.template", "");
		if ("".equalsIgnoreCase(wsnavibusPathString)) {
			
			System.exit(-3);
		}
		wsnavibusPathString = ConstantsParseDate.parseDay(wsnavibusPathString, date);
		
		MultipleInputs.addInputPath(job, new Path(aosbusrouPathString), TextInputFormat.class, StatBusRouteMapper.class);
		MultipleInputs.addInputPath(job, new Path(aoswalkrouPathString), TextInputFormat.class, StatWalkRouteMapper.class);
		MultipleInputs.addInputPath(job, new Path(wsnaviautoPathString), TextInputFormat.class, StatNaviAutoMapper.class);
		MultipleInputs.addInputPath(job, new Path(wsnavibusPathString), TextInputFormat.class, StatNaviBusMapper.class);
	
		
		String outputPathString = conf.get("mapred.job.statallnavi.output.datapath.template", "");
		
		if ("".equalsIgnoreCase(outputPathString)) {
			System.out.println("ERROR.job output path should be \"\"");
			System.exit(-3);
		}
		outputPathString = ConstantsParseDate.parseDay(outputPathString, date);		
		Path outputPath = new Path(outputPathString);
		FileSystem fileSystem = FileSystem.get(URI.create(outputPathString), job.getConfiguration());
		fileSystem.delete(outputPath, true);
		FileOutputFormat.setOutputPath(job, outputPath);
		MultipleOutputs.addNamedOutput(job, "text", TextOutputFormat.class,
				 Text.class, NullWritable.class);
		
		
		return job.waitForCompletion(true) ? 0 : 1;
	}



}
