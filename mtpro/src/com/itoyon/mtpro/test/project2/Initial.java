package com.itooy.project2;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月18日 下午9:47:24
 */
public class Initial {
	public static void main(String[] args) {
		Shape rectShape = new Rectangle();
		Shape circShape = new Circle();

		System.out.println("矩形的周长：" + rectShape.getPerimeter());
		System.out.println("矩形的面积：" + rectShape.getAcreage());
		System.out.println("圆的周长：" + circShape.getPerimeter());
		System.out.println("圆形的面积：" + circShape.getAcreage());
	}
}
