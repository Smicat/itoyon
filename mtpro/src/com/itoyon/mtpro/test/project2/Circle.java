package com.itooy.project2;

/**
 * @Description: 求圆的周长和面积
 * @author: Stone
 * @date: 2018年4月18日 下午10:29:42
 */
public class Circle extends Shape {

	/**
	 * 圆的半径
	 */
	private static final double R = 3;

	/**
	 * 求周长
	 */
	public double getPerimeter() {
		return 2 * R * Math.PI;
	}

	/**
	 * 求面积
	 */
	public double getAcreage() {
		return Math.pow(R, 2) * Math.PI;
	}

}
