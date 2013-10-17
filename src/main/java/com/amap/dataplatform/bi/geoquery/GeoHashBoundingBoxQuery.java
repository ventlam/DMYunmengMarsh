
package com.amap.dataplatform.bi.geoquery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.amap.dataplatform.bi.geoutil.BoundingBox;
import com.amap.dataplatform.bi.geoutil.GeoHash;
import com.amap.dataplatform.bi.geoutil.GeoHashSizeTable;
import com.amap.dataplatform.bi.geoutil.WGS84Point;

/**
 * 返回BBox内地理hash值，其个数可能是1,2,4
 */
public class GeoHashBoundingBoxQuery implements GeoHashQuery, Serializable {
	private static final long serialVersionUID = 9223256928940522683L;
	/* 不会超过4个地理hash值 */
	private List<GeoHash> searchHashes = new ArrayList<GeoHash>(4);
	/* 以上所有地理hash的最大bbox. */
	private BoundingBox boundingBox;

	public GeoHashBoundingBoxQuery(BoundingBox bbox) {
		int fittingBits = GeoHashSizeTable.numberOfBitsForOverlappingGeoHash(bbox);
		WGS84Point center = bbox.getCenterPoint();
		GeoHash centerHash = GeoHash.withBitPrecision(center.getLatitude(), center.getLongitude(), fittingBits);

		if (hashFits(centerHash, bbox)) {
			addSearchHash(centerHash);
		} else {
			expandSearch(centerHash, bbox);
		}
	}

	private void addSearchHash(GeoHash hash) {
		if (boundingBox == null) {
			boundingBox = new BoundingBox(hash.getBoundingBox());
		} else {
			boundingBox.expandToInclude(hash.getBoundingBox());
		}
		searchHashes.add(hash);
	}

	private void expandSearch(GeoHash centerHash, BoundingBox bbox) {
		addSearchHash(centerHash);

		for (GeoHash adjacent : centerHash.getAdjacent()) {
			BoundingBox adjacentBox = adjacent.getBoundingBox();
			if (adjacentBox.intersects(bbox) && !searchHashes.contains(adjacent)) {
				addSearchHash(adjacent);
			}
		}
	}

	private boolean hashFits(GeoHash hash, BoundingBox bbox) {
		return hash.contains(bbox.getUpperLeft()) && hash.contains(bbox.getLowerRight());
	}

	public boolean contains(GeoHash hash) {
		for (GeoHash searchHash : searchHashes) {
			if (hash.within(searchHash)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(WGS84Point point) {
		return contains(GeoHash.withBitPrecision(point.getLatitude(), point.getLongitude(), 64));
	}

	public List<GeoHash> getSearchHashes() {
		return searchHashes;
	}

	@Override
	public String toString() {
		StringBuilder bui = new StringBuilder();
		for (GeoHash hash : searchHashes) {
			bui.append(hash).append("\n");
		}
		return bui.toString();
	}

	public String getWktBox() {
		return "BOX(" + boundingBox.getMinLon() + " " + boundingBox.getMinLat() + "," + boundingBox.getMaxLon() + " "
				+ boundingBox.getMaxLat() + ")";
	}
}
