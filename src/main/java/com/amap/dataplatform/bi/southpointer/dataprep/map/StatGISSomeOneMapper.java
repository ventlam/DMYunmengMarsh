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

public class StatGISSomeOneMapper extends
		Mapper<Object, Text, Text, NullWritable> {

	/**
	 * @param args
	 */
	//private final static LongWritable mapOutValue = new LongWritable(1);
	private Text mapOutKey = new Text();
	public void map(Object key,Text value,Context context) throws IOException, InterruptedException
		{
		    //parse hive to get datebuf,uid,vid
			String crtime,diu;

			//double[] latlng = new double[2];
			String[] inSplit = value.toString().split(ConstantsParseInput.tableFieldsSeparator,
					ConstantsParseInput.tableDMUserGISFieldsLength);
			
			if(inSplit.length!= ConstantsParseInput.tableDMUserGISFieldsLength)
			{
				//check out the origin data 
				System.out.println(value.toString());
			}
			else {
				//Get date,diu,x1,y1,x2,y2,entrytime,exittime
				crtime = inSplit[0].trim();
				diu = inSplit[2].trim();		
        		String x = inSplit[4].trim();
				String y = inSplit[5].trim();
			
				//只写入有效数据
				if(diu.equalsIgnoreCase("a034119aa4f96dbddfc5293321530408"))
				{
				//Splice the output key using || 
				String outvalue = diu + ConstantsParseInput.mapreduceFieldsSeparator + 
								crtime+ ConstantsParseInput.mapreduceFieldsSeparator +
								x+ ConstantsParseInput.mapreduceFieldsSeparator +
								y;
				mapOutKey.set(outvalue);
				//mapOutValue.set(outvalue);
				context.write(mapOutKey, NullWritable.get());
				}
			}
		}
}
