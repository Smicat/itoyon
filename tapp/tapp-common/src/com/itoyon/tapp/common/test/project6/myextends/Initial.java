package com.itoyon.tapp.common.test.project6.myextends;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月16日 下午10:13:31
 */
public class Initial {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.eat();
		Cat cat2 = new Cat();
		System.out.println(cat.equals(cat2));
		System.out.println(cat);
		System.out.println(cat2);
		/*System.out.println(cat.getClass());
		System.out.println(cat2.getClass());*/
	}
}
