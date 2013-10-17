package com.amap.dataplatform.bi.geoutil;
/*
 * Conf to parse hive tables 
 *
 */
public class CommonUtil {
	
	
	public static double[] pixel2lnglat(double xs,double ys)
	{
		double[] latlng = new double[2];
		double pow = Math.pow(2.0, 20.0);
		double exp = Math.exp(4 * Math.PI * (0.5 - ys / 256 / pow));
		double lng = xs / 256 / pow * 360 - 180;
	    double lat = Math.asin((exp - 1) / (exp + 1)) / Math.PI * 180;
	    latlng[0] = lng;
	    latlng[1] = lat;
	    return latlng;
	}
	 public static double calDistance(double lat1, double lon1, double lat2, double lon2)
	 {
		 double theta = lon1 - lon2;
	      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) 
	      + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	      dist = Math.acos(dist);
	      dist = rad2deg(dist);
	      dist = dist * 60 * 1.1515 * 1.609344;
	      return (dist);
	 }
	private static double deg2rad(double deg) {
		      return (deg * Math.PI / 180.0);
		    }

	private static double rad2deg(double rad) {
		      return (rad * 180.0 / Math.PI);
		    }

	
}
