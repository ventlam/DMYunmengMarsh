package com.amap.dataplatform.bi.common;
/*
 * Conf to parse hive tables 
 *
 */
public class ConstantsParseInput {
	
	
	public static String tableFieldsSeparator = "\\|\\|";	
	
	//target service: ods_aos_busroute
	public static int  servaosfieldlen_busroute = 46;


	//target service: ods_aos_walkroute
	public static int  servaosfieldlen_walkroute = 44;
	
	public static Integer tableAosCarRouteFieldsLength = 47;
	public static Integer tableNaviAutoFieldsLength = 63;
	//target service: ods_ws_navigation_bus
	public static int  servwsfieldlen_navbus = 62;

	//target service: ods_ws_navigation_foot
	public static int  servwsfieldlen_navfoot = 48;
	public static Integer tableMpsCarRouteFieldsLength = 0;
	public static Integer tableDMUserGISFieldsLength = 6;
	public static Integer tableAosRcsFieldsLength = 41;
	
	public static Integer tableAosTrafficFieldsLength = 53;
	
	public static String mapreduceFieldsSeparator = "||";	

	public static String  timeButtonSeparator       = "@";
	public static String  MatrixSeparator		    = ",";
	public static Integer MatrixLength              = 1000;
	
	public static Integer tableProduceLength  = 6;
	
	//use for detect imei
	public static final String IOSDIU = "52270117dbadbea6b8679cc9ecd7684a";
	public static final String ANDDIC = "C7348";
	
}
