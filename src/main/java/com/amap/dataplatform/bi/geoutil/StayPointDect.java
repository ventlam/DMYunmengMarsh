package com.amap.dataplatform.bi.geoutil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.hadoop.io.Text;

import com.amap.dataplatform.bi.common.ConstantsParseInput;

public class StayPointDect {

	/**
	 * @param args
	 */
	 
	public StayPointDect(ArrayList log,long pointnum,long disT,long timeT)
	{
		
		int i = 0;
		while (i<pointnum)
		{
			int j = i+1;
			int token = 0;
			while (j<pointnum)
			{
				//需要修改
			 String	iString = (String) log.get(i);
			 String[] iStringArr = iString.split(ConstantsParseInput.tableFieldsSeparator);
			 String	jString = (String) log.get(j);
			 String[] jStringArr = jString.split(ConstantsParseInput.tableFieldsSeparator);
			 double dist = CommonUtil.calDistance(Double.parseDouble(iStringArr[2]),
					 Double.parseDouble(iStringArr[2]),Double.parseDouble(iStringArr[2]),Double.parseDouble(iStringArr[2]));
				 if (dist > disT)
				 {
					 double spanT = Double.parseDouble(iStringArr[4])-Double.parseDouble(jStringArr[4]);
					 if(spanT>timeT)
					 {
						 double kxall =0.0;
						 double kyall =0.0;
						 int k =0;
						 for( k=i;k<j;k++)
						 {
							 String	kString = (String) log.get(k);
							 String[] kStringArr = kString.split(ConstantsParseInput.tableFieldsSeparator);
							  kxall = kxall+Double.parseDouble(kStringArr[2]);
							  kyall = kxall+Double.parseDouble(kStringArr[3]);
						 }
						 double kxmean = kxall/k;
						 double kymean = kyall/k;
						 double arvT = Double.parseDouble(iStringArr[4]);
						 double levT = Double.parseDouble(jStringArr[4]);
						 
					 }
				 }
				  
			}
		}
		//return hm;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
