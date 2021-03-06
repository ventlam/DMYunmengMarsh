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

public class StatAosCarRouteMapper extends
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
			double x1=0.0,y1=0.0,x2=0.0,y2=0.0;
			
			String[] inSplit = value.toString().split(ConstantsParseInput.tableFieldsSeparator,
					ConstantsParseInput.tableAosCarRouteFieldsLength);
			
			if(inSplit.length!= ConstantsParseInput.tableAosCarRouteFieldsLength)
			{
				//check out the origin data 
				System.out.println(value.toString());
			}
			else {
				//Get date,diu,x1,y1,x2,y2,entrytime,exittime
				crtime = inSplit[0].trim();
				diu = inSplit[17].trim();		
				//20级像素坐标转换成经纬度坐标
				double[] latlngst = new double[2];
				double[] latlnged = new double[2];
				
				for(int i=9;i<=12;i++)
				{
					if(inSplit[i].trim().contains("%7C"))
					{
						inSplit[i]=inSplit[i].trim().split("%7C")[0];
					}
				}
				String source = inSplit[7].trim();
				String xsstr = inSplit[9].trim();
				String ysstr = inSplit[10].trim();
				String xestr = inSplit[11].trim();
				String yestr = inSplit[12].trim();
				String model = inSplit[22].trim().replaceAll("\\.", "");;
				String diu2	 = inSplit[45].trim();
				String diu3	 = inSplit[46].trim();
				
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
				if(source.equalsIgnoreCase(""))
				{
					source = "no";
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
						&&!diu.equalsIgnoreCase("0")&&!source.equalsIgnoreCase(""))
				{
				//Splice the output key using || 
				String outvalue = x1+ ConstantsParseInput.mapreduceFieldsSeparator +
								y1+ ConstantsParseInput.mapreduceFieldsSeparator +
								x2+ ConstantsParseInput.mapreduceFieldsSeparator +
								y2;
				String outkey   = diu+ConstantsParseInput.mapreduceFieldsSeparator + source;
				mapOutKey.set(outkey);
				System.out.println(outkey);
				mapOutValue.set(outvalue);
				context.write(mapOutKey, mapOutValue);
				}
			}
		}
}
