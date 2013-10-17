package com.amap.dataplatform.bi.southpointer.dataprep.reduce;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import com.amap.dataplatform.bi.common.ConstantsParseInput;

public class StatTop5Reducer extends Reducer<Text,LongWritable,Text,NullWritable>{
	public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException
	{
		//count * from  dh 
		long sum = 0;
		for(LongWritable val : values)
		{
			sum += val.get();
		}
		if(sum>=10000)
		{
		//System.out.println("sum: "+sum);
		//Splice stat_hourlocate 
		String keyString = sum + ConstantsParseInput.mapreduceFieldsSeparator + key.toString();
		//String keyString = "10000";
		key.set(keyString);
		context.write(key, NullWritable.get());	
		}
	}

}
