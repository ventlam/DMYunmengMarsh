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

public class StatAllNaviSJReducer extends Reducer<Text,Text,Text,NullWritable>{
	
	
	private Text out =  new Text();
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{		
		//context.write(key, NullWritable.get());
			for(Text val : values)
			{
				String outstr = key.toString()+ ConstantsParseInput.mapreduceFieldsSeparator +
								val.toString();
				out.set(outstr);
				context.write(out, NullWritable.get());
			}
	}
			
}

