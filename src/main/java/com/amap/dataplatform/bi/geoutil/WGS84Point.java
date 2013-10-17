
package com.amap.dataplatform.bi.geoutil;

import java.io.Serializable;

/**
 * {@link WGS84Point} encapsulates coordinates on the earths surface.<br>
 * Coordinate projections might end up using this class...
 */
public class WGS84Point implements Serializable {
	private static final long serialVersionUID = 7457963026513014856L;
	private double longitude;
	private double latitude;

	public WGS84Point(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		if (Math.abs(latitude) > 90 || Math.abs(longitude) > 180) {
			throw new IllegalArgumentException("The supplied coordinates " + this + " are out of range.");
		}
	}

	public WGS84Point(WGS84Point other) {
		this(other.latitude, other.longitude);
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return String.format("(" + latitude + "," + longitude + ")");
	}
	//对比是否同一个点
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof WGS84Point) {
			WGS84Point other = (WGS84Point) obj;
			return latitude == other.latitude && longitude == other.longitude;
		}
		return false;
	}
	//点的hash值
	@Override
	public int hashCode() {
		int result = 42;
		long latBits = Double.doubleToLongBits(latitude);
		System.out.println("latBits: "+ latBits);
		long lonBits = Double.doubleToLongBits(longitude);
		System.out.println("lonBits: "+ lonBits);
		//无符号右移 
		result = 31 * result + (int) (latBits ^ (latBits >>> 32));
		System.out.println("latBits >>> 32 : "+ (latBits >>> 32));
		System.out.println("latBits result: "+ result);
		result = 31 * result + (int) (lonBits ^ (lonBits >>> 32));
		System.out.println("lonBits >>> 32 : "+ (lonBits >>> 32));
		System.out.println("lonBits result: "+ result);
		return result;
	}
	public static void  main(String[] args)
	{
		WGS84Point ws = new WGS84Point(1.0,1.0);
		ws.hashCode();
	}
}
