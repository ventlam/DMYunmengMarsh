package com.amap.dataplatform.bi.southpointer.dataprep.job;

import java.io.IOException;
import java.net.URI;
import java.sql.Timestamp;
import java.text.DateFormat;
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
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import com.amap.dataplatform.bi.common.ConstantsParseDate;
import com.amap.dataplatform.bi.common.ConstantsParseInput;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatAosCarRouteMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatAosRcsMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.map.StatAosTrafficMapper;
import com.amap.dataplatform.bi.southpointer.dataprep.reduce.StatAosCarRouteReducer;
import com.amap.dataplatform.bi.southpointer.dataprep.reduce.StatAosRcsReducer;
import com.amap.dataplatform.bi.southpointer.dataprep.reduce.StatAosTrafficReducer;

public class StatAosTrafficJob extends Configured implements Tool{
	public static void main(String[] args) throws Exception {
		int exitCode = ToolRunner.run(new StatAosTrafficJob(),  args);
		System.out.println(exitCode);
	}

	public int run(String[] arg0) throws Exception {
		
		// read job conf from xml 
		Configuration conf = new Configuration();
		conf.addResource("configuration.xml");
		conf.set("mapred.job.queue.name", "amap"); 
		conf.set("mapred.queue.name","amap");
		conf.set("mapred.job.priority", JobPriority.VERY_HIGH.toString());
		conf.set("mapred.textoutputformat.separatorText", ",");
		
		//parse date , get/set job prefix
		Date date = new Date();
		
		Job job = new Job(conf,"stat_aos_traffic job");
	 	job.setJarByClass(StatAosTrafficJob.class);
    	job.setMapperClass(StatAosTrafficMapper.class);
    	job.setReducerClass(StatAosTrafficReducer.class);
    	job.setMapOutputKeyClass(Text.class);
    	job.setMapOutputValueClass(Text.class);
    	job.setOutputKeyClass(Text.class);
    	job.setOutputValueClass(NullWritable.class);
    	job.setNumReduceTasks(100);
		String inputPathString = conf.get("mapred.job.stataostraffic.input.datapath.template", "");
		if ("".equalsIgnoreCase(inputPathString)) {
			System.out.println("ERROR.job input path should be \"\"");
			System.exit(-3);
		}
		inputPathString = ConstantsParseDate.parseDay(inputPathString, date);
		FileInputFormat.addInputPath(job, new Path(inputPathString));
		
		String outputPathString = conf.get("mapred.job.stataostraffic.output.datapath.template", "");
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
