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

public class StatNaviAutoMapper extends
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
			String crtime;
			double x1=0.0,y1=0.0,x2=0.0,y2=0.0;
			
			String[] inSplit = value.toString().split(ConstantsParseInput.tableFieldsSeparator,
					ConstantsParseInput.tableNaviAutoFieldsLength);
			
			if(inSplit.length!= ConstantsParseInput.tableNaviAutoFieldsLength)
			{
				//check out the origin data 
				System.out.println(value.toString());
			}
			else {
				//Get date,diu,x1,y1,x2,y2,entrytime,exittime
				crtime = inSplit[0].trim();
				
				//20级像素坐标转换成经纬度坐标
				double[] latlngst = new double[2];
				double[] latlnged = new double[2];
				
				for(int i=8;i<=11;i++)
				{
					if(inSplit[i].trim().contains("%7C"))
					{
						inSplit[i]=inSplit[i].trim().split("%7C")[0];
					}
				}
				
				String xsstr = inSplit[8].trim();
				String ysstr = inSplit[9].trim();
				String xestr = inSplit[10].trim();
				String yestr = inSplit[11].trim();
				String model = inSplit[57].trim().replaceAll("\\.", "");;
				String diu 	 = inSplit[32].trim();	
				String diu2	 = inSplit[33].trim();
				String diu3	 = inSplit[34].trim();
				
				if(model!=null && !model.equals(""))
				{
					if (diu.toUpperCase().contains("IOSH") && Integer.parseInt(model)>=700) {

						if (diu2 != null && !diu2.equals("")) {
							diu = diu2;
						} else {
							if (diu3 != null && !diu3.equals("")) {
								diu = diu3;
							}
						}
					}
				}
				//抛掉xy坐标为空的情况
				try {
					if(!xsstr.equals("")&&!ysstr.equals("")&&!xestr.equals("")&&!yestr.equals(""))
					{
					latlngst = CommonUtil.pixel2lnglat(Double.parseDouble(xsstr), Double.parseDouble(ysstr));
					latlnged =CommonUtil.pixel2lnglat(Double.parseDouble(xestr),Double.parseDouble(yestr));
					//起点经纬度
					x1 = latlngst[0];
					y1 = latlngst[1];
					//终点经纬度
					x2 = latlnged[0];
					y2 = latlnged[1];
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//只写入有效数据
				if(x1!=0.0&&y1!=0.0&&x2!=0.0&&y2!=0.0&&!diu.equalsIgnoreCase("")
						&&!diu.equals("0"))
				{
				//Splice the output key using || 
				String outvalue = x1+ ConstantsParseInput.mapreduceFieldsSeparator +
								y1+ ConstantsParseInput.mapreduceFieldsSeparator +
								x2+ ConstantsParseInput.mapreduceFieldsSeparator +
								y2;
				String outkey   = diu;
				mapOutKey.set(outkey);
				System.out.println(outkey);
				mapOutValue.set(outvalue);
				context.write(mapOutKey, mapOutValue);
				}
			}
		}
}
