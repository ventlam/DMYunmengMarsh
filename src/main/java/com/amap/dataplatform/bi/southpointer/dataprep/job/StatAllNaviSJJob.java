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
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import com.amap.dataplatform.bi.common.ConstantsParseDate;
import com.amap.dataplatform.bi.common.ConstantsParseInput;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatAllNaviSJMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatAosCarRouteMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.reduce.StatAllNaviSJReducer;
import com.amap.dataplatform.bi.southpointer.dataprep.reduce.StatAosCarRouteReducer;


public class StatAllNaviSJJob extends Configured implements Tool{
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new StatAllNaviSJJob(),  args);
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
		
		
		Job job = new Job(conf,"stat_aos_car_route _sj_dic_job"+ConstantsParseDate.outputDate(date));
	 	job.setJarByClass(StatAllNaviSJJob.class);
    	job.setMapperClass(StatAllNaviSJMapper.class);
    	job.setReducerClass(StatAllNaviSJReducer.class);
    	job.setMapOutputKeyClass(Text.class);
    	job.setMapOutputValueClass(Text.class);
    	job.setOutputKeyClass(Text.class);
    	job.setOutputValueClass(NullWritable.class);
    	job.setNumReduceTasks(1);
		String inputPathString = conf.get("mapred.job.statallnavi_nvsj.input.datapath.template", "");
		if ("".equalsIgnoreCase(inputPathString)) {
			System.out.println("ERROR.job input path should be \"\"");
			System.exit(-3);
		}
		inputPathString = ConstantsParseDate.parseDay(inputPathString, date);
		FileInputFormat.addInputPath(job, new Path(inputPathString));
		
		String outputPathString = conf.get("mapred.job.statallnavi_nvsj.output.datapath.template", "");
		
		if ("".equalsIgnoreCase(outputPathString)) {
			System.out.println("ERROR.job output path should be \"\"");
			System.exit(-3);
		}
		outputPathString = ConstantsParseDate.parseDay(outputPathString, date);		
		Path outputPath = new Path(outputPathString);
		FileSystem fileSystem = FileSystem.get(URI.create(outputPathString), job.getConfiguration());
		fileSystem.delete(outputPath, true);
		FileOutputFormat.setOutputPath(job, outputPath);
		
		
		return job.waitForCompletion(true) ? 0 : 1;
	}



}
