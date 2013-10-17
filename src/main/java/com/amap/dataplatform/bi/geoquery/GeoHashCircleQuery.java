
package com.amap.dataplatform.bi.geoquery;

import java.io.Serializable;
import java.util.List;

import com.amap.dataplatform.bi.geoutil.BoundingBox;
import com.amap.dataplatform.bi.geoutil.GeoHash;
import com.amap.dataplatform.bi.geoutil.GeographDistance;
import com.amap.dataplatform.bi.geoutil.WGS84Point;


/**
 * represents a radius search around a specific point via geohashes.
 * Approximates the circle with a square!
 */
public class GeoHashCircleQuery implements GeoHashQuery, Serializable {
	private static final long serialVersionUID = 1263295371663796291L;
	private double radius;
	private GeoHashBoundingBoxQuery query;
	private WGS84Point center;

	/**
	 * create a {@link GeoHashCircleQuery} with the given center point and a
	 * radius in meters.
	 */
	public GeoHashCircleQuery(WGS84Point center, double radius) {
		this.radius = radius;
		this.center = center;
		WGS84Point northEast = GeographDistance.moveInDirection(GeographDistance.moveInDirection(center, 0, radius), 90,
				radius);
		WGS84Point southWest = GeographDistance.moveInDirection(GeographDistance.moveInDirection(center, 180, radius),
				270, radius);
		BoundingBox bbox = new BoundingBox(northEast, southWest);
		query = new GeoHashBoundingBoxQuery(bbox);
	}

	public boolean contains(GeoHash hash) {
		return query.contains(hash);
	}

	public String getWktBox() {
		return query.getWktBox();
	}

	public List<GeoHash> getSearchHashes() {
		return query.getSearchHashes();
	}

	@Override
	public String toString() {
		return "Cicle Query [center=" + center + ", radius=" + getRadiusString() + "]";
	}

	private String getRadiusString() {
		if (radius > 1000) {
			return radius / 1000 + "km";
		} else {
			return radius + "m";
		}
	}

	public boolean contains(WGS84Point point) {
		return query.contains(point);
	}
}
