package com.amap.dataplatform.bi.common;
/*
 * Conf to parse hive tables 
 *
 */
public class ConstantsParseInput {
	
	
	public static String tableFieldsSeparator = "\\|\\|";	
	
	public static Integer tableAosCarRouteFieldsLength = 45;
	public static Integer tableMpsCarRouteFieldsLength = 0;
	public static Integer tableDMUserGISFieldsLength = 6;
	public static Integer tableAosRcsFieldsLength = 41;
	
	public static Integer tableAosTrafficFieldsLength = 53;
	
	public static String mapreduceFieldsSeparator = "||";	

	public static String  timeButtonSeparator       = "@";
	public static String  MatrixSeparator		    = ",";
	public static Integer MatrixLength              = 1000;
	
	
	//use for detect imei
	public static final String IOSDIU = "52270117dbadbea6b8679cc9ecd7684a";
	public static final String ANDDIC = "C7348";
	
}
