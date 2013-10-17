package com.amap.dataplatform.bi.southpointer.dataprep.reduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

import com.amap.dataplatform.bi.common.ConstantsParseInput;

public class StatAosCarRouteReducer extends Reducer<Text,Text,Text,NullWritable>{
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{
		//count * from  use_time 
		long sum = 0;
		Iterator<Text> it = values.iterator();
		if (it.hasNext())
		{
			sum++;	
		}
		if(sum>=5)
		{
			for(Text val : values)
			{
				String setout = val.toString() + ConstantsParseInput.mapreduceFieldsSeparator+sum;
				val.set(setout);
				context.write(val, NullWritable.get());
				
			}
		}
			
	}

}
