package com.amap.dataplatform.bi.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConstantsParseDate {
	public static String parseDay(String PathString, Date date) {
		String year;
		String month;
		String day;
		//excute the job of yesterday.
		GregorianCalendar gregorianCalendar = new GregorianCalendar(); 
		gregorianCalendar.setTime(date);
		gregorianCalendar.add(Calendar.DATE, -1);
		date = gregorianCalendar.getTime();
		
		SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
		year = yearDateFormat.format(date);
		SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
		month = monthDateFormat.format(date);
		SimpleDateFormat dayDateFormat = new SimpleDateFormat("dd");
		day = dayDateFormat.format(date);

		PathString = PathString.replace("${year}", year);
		PathString = PathString.replace("${month}", month);
		PathString = PathString.replace("${day}", day);

		return PathString;
	}
	public static String parseMonth(String PathString, Date date) {
		String year;
		String month;
		
		//excute the job of yesterday.
		GregorianCalendar gregorianCalendar = new GregorianCalendar(); 
		gregorianCalendar.setTime(date);
		gregorianCalendar.add(Calendar.DATE, -1);
		date = gregorianCalendar.getTime();
		
		SimpleDateFormat yearDateFormat = new SimpleDateFormat("yyyy");
		year = yearDateFormat.format(date);
		SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
		month = monthDateFormat.format(date);


		PathString = PathString.replace("${year}", year);
		PathString = PathString.replace("${month}", month);

		return PathString;
	}
		public static String outputDate(Date date)
	   {
		   GregorianCalendar gregorianCalendar = new GregorianCalendar(); 
			gregorianCalendar.setTime(date);
			gregorianCalendar.add(Calendar.DATE, -1);
			date = gregorianCalendar.getTime();
			return  date.toString();
	   }
}
