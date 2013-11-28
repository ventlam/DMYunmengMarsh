package com.amap.dataplatform.bi.southpointer.dataprep.reduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

import com.amap.dataplatform.bi.common.ConstantsParseInput;

public class StatAosCarRouteReducer extends Reducer<Text,Text,Text,NullWritable>{
	
	private MultipleOutputs<?, ?> mos;
	 @Override
	 public void setup(Context context) {
		
		 mos = new MultipleOutputs(context);
		 }
	 
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{
			
		
			String[] keys  	 =  key.toString().split(ConstantsParseInput.tableFieldsSeparator);
			String   diu   	 =  keys[0];
			String   source  =  keys[1];
			for(Text val : values)
			{
				String   keyString = diu + ConstantsParseInput.mapreduceFieldsSeparator +val.toString();
				mos.write("text", keyString,NullWritable.get(),source+"/party");
			}
			
			
	}
	public void cleanup(Context context) throws IOException {
		 try {
			mos.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 }

}
