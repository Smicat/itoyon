package com.itoyon.tapp.wpro.util.geo;

import java.util.HashMap;
import java.util.Map;

public class GeoAround {

	public static void main(String[] args) {
		System.out.println(getAround("104.594472", "30.039458", "1000"));
	}

	/**
	 * <PRE>
	 * 获取当前用户一定距离以内的经纬度值
	 * 单位米 return minLat
	 * 最小经度 minLng
	 * 最小纬度 maxLat
	 * 最大经度 maxLng
	 * 最大纬度 minLat
	 * </PRE>
	 */
	public static Map<String, String> getAround(String latStr, String lngStr, String raidus) {
		Double latitude = Double.parseDouble(latStr);// 传值给经度
		Double longitude = Double.parseDouble(lngStr);// 传值给纬度

		Double degree = (24901 * 1609) / 360.0; // 获取每度
		double raidusMile = Double.parseDouble(raidus);

		Double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180)) + "").replace("-", ""));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		// 获取最小经度
		Double minLat = longitude - radiusLng;
		// 获取最大经度
		Double maxLat = longitude + radiusLng;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		// 获取最小纬度
		Double minLng = latitude - radiusLat;
		// 获取最大纬度
		Double maxLng = latitude + radiusLat;

		Map<String, String> map = new HashMap<String, String>();
		map.put("minLat", minLat + "");
		map.put("maxLat", maxLat + "");
		map.put("minLng", minLng + "");
		map.put("maxLng", maxLng + "");

		return map;
	}
}