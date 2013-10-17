package com.amap.dataplatform.bi.geoquery;

import java.util.List;

import com.amap.dataplatform.bi.geoutil.GeoHash;
import com.amap.dataplatform.bi.geoutil.WGS84Point;


public interface GeoHashQuery {

	/**
	 * 返回是否包含该地理hash值
	 */
	public boolean contains(GeoHash hash);

	/**
	 * 返回是否包含一个WGS84的点
	 */
	public boolean contains(WGS84Point point);

	/**
	 * 返回空间查询所需的hash值
	 */
	public List<GeoHash> getSearchHashes();

	public String getWktBox();

}