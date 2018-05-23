package com.itoyon.tapp.wpro.util.geo;

public class GeoDistance {

	private static double EARTH_RADIUS = 6371.393; // 地球半径（单位km）

	public static void main(String[] args) {
		System.out.println(getDistance("104.603457", "30.075117", "104.585486", "30.075117"));
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 根据两个位置的经纬度，来计算两地的距离（单位为m） 参数为String类型
	 *
	 * @param lng1Str
	 *            用户经度
	 * @param lat1Str
	 *            用户纬度
	 * @param lng2Str
	 *            目标经度
	 * @param lat2Str
	 *            目标纬度
	 * @return
	 */
	public static Long getDistance(String lng1Str, String lat1Str, String lng2Str, String lat2Str) {
		Long distance = 0L;
		Double lat1 = Double.parseDouble(lat1Str);
		Double lng1 = Double.parseDouble(lng1Str);
		Double lat2 = Double.parseDouble(lat2Str);
		Double lng2 = Double.parseDouble(lng2Str);

		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double difference = radLat1 - radLat2;
		double mdifference = rad(lng1) - rad(lng2);
		double dis = 2 * Math.asin(Math.sqrt(
				Math.pow(Math.sin(difference / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(mdifference / 2), 2)));
		dis = dis * EARTH_RADIUS;
		distance = Math.round(dis * 1000);

		return distance;
	}

}