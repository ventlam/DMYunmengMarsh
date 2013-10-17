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

public class StatAosRcsMapper extends
		Mapper<Object, Text, Text, Text> {

	/**
	 * @param args
	 */
	//private final static LongWritable mapOutValue = new LongWritable(1);
	private Text mapOutKey = new Text();
	private Text mapOutValue = new Text();
	public void map(Object key,Text value,Context context) throws IOException, InterruptedException
		{
		    //parse hive to get datebuf,uid,vid
			String crtime,diu;
			double x=0.0,y=0.0;
			double[] latlng = new double[2];
			String[] inSplit = value.toString().split(ConstantsParseInput.tableFieldsSeparator,
					ConstantsParseInput.tableAosRcsFieldsLength);
			
			if(inSplit.length!= ConstantsParseInput.tableAosRcsFieldsLength)
			{
				//check out the origin data 
				System.out.println(value.toString());
			}
			else {
				//Get date,diu,x1,y1,x2,y2,entrytime,exittime
				crtime = inSplit[0].trim();
				diu = inSplit[13].trim();		
				//20级像素坐标转换成经纬度坐标
				String xstr = inSplit[6].trim();
				String ystr = inSplit[7].trim();
				System.out.println("x: "+xstr);
				System.out.println("y: "+ystr);
				//抛掉xy坐标为空的情况
				try {
					if(!xstr.equalsIgnoreCase("")&&!ystr.equalsIgnoreCase(""))
					{
						latlng = CommonUtil.pixel2lnglat(Double.parseDouble(xstr), Double.parseDouble(ystr));
						//经纬度
						x = latlng[0];
						y = latlng[1];
						System.out.println("lng: "+x);
						System.out.println("lat: "+y);
					}
								
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//只写入有效数据
				if(x!=0.0&&y!=0.0&&!diu.equalsIgnoreCase("")
						&&!diu.equalsIgnoreCase("0"))
				{
				//Splice the output key using || 
				String outvalue = diu + ConstantsParseInput.mapreduceFieldsSeparator + 
								crtime+ ConstantsParseInput.mapreduceFieldsSeparator +
								x+ ConstantsParseInput.mapreduceFieldsSeparator +
								y;
				mapOutKey.set(diu);
				mapOutValue.set(outvalue);
				context.write(mapOutKey, mapOutValue);
				}
			}
		}
}
