package com.itooy.project2;

/**
 * @Description: 求矩形的周长和面积
 * @author: Stone
 * @date: 2018年4月18日 下午10:27:23
 */
public class Rectangle extends Shape {

	/**
	 * 矩形的长度
	 */
	private static final double A = 3;
	
	/**
	 * 矩形的宽度
	 */
	private static final double B = 4;

	/**
	 * 求周长
	 */
	public double getPerimeter() {
		return 2 * (A + B);
	}

	/**
	 * 求面积
	 */
	public double getAcreage() {
		return A * B;
	}

}
