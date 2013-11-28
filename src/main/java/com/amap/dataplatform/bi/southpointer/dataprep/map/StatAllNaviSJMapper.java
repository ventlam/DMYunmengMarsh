package com.amap.dataplatform.bi.southpointer.dataprep.map;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

import com.amap.dataplatform.bi.common.ConstantsParseInput;
import com.amap.dataplatform.bi.geoutil.CommonUtil;

public class StatAllNaviSJMapper extends
		Mapper<Object, Text, Text, Text> {

	/**
	 * @param args
	 */
	//private final static LongWritable mapOutValue = new LongWritable(1);
	private Text mapOutKey = new Text();
	private Text mapOutValue = new Text();
	public void map(Object key,Text value,Context context) throws IOException, InterruptedException
		{	
			String[] inSplit = value.toString().split(ConstantsParseInput.MatrixSeparator,
					ConstantsParseInput.tableProduceLength);
			
			if(inSplit.length!= ConstantsParseInput.tableProduceLength)
			{
				//check out the origin data 
				System.out.println(value.toString());
			}
			else {
				//Get date,diu,x1,y1,x2,y2,entrytime,exittime
				String diu = 	inSplit[0].trim();
				String x1  =    inSplit[1].trim();
				String y1  =    inSplit[2].trim();
				String x2  =    inSplit[3].trim();
				String y2  =    inSplit[4].trim();
				String adcode = inSplit[5].trim();
				System.out.println(adcode);
				if(adcode.equalsIgnoreCase("110000"))
				{
					mapOutKey.set(diu);
					String val = x1+ConstantsParseInput.mapreduceFieldsSeparator+
								 y1+ConstantsParseInput.mapreduceFieldsSeparator+
								 x2+ConstantsParseInput.mapreduceFieldsSeparator+
								 y2+ConstantsParseInput.mapreduceFieldsSeparator+
								 adcode;
					mapOutValue.set(val);
					context.write(mapOutKey, mapOutValue);
				}
				}
			}
}
