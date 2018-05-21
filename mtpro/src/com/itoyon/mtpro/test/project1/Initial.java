package com.itooy.project1;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月18日 下午9:47:24
 */
public class Initial {
	public static void main(String[] args) {
		Phone p = new Phone();
		Phone p1 = new CellPhone();
		Phone p2 = new SmartPhone();
		p.call();
		p1.call();
		p2.call();

		if (p2 instanceof SmartPhone) {
			SmartPhone sp = (SmartPhone) p2;
		} else {
			System.out.println("无法进行类型转换，SmartPhone！");
		}

		if (p2 instanceof CellPhone) {
			CellPhone cp = (CellPhone) p2;
		} else {
			System.out.println("无法进行类型转换，CellPhone！");
		}
	}
}
