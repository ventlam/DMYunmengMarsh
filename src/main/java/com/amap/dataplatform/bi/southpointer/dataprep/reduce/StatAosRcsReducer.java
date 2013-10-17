package com.amap.dataplatform.bi.southpointer.dataprep.reduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import com.amap.dataplatform.bi.common.ConstantsParseInput;

public class StatAosRcsReducer extends Reducer<Text,Text,Text,NullWritable>{
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{
		
		
			for(Text val : values)
			{

				context.write(val, NullWritable.get());
				
			}
		}
			
	

}
