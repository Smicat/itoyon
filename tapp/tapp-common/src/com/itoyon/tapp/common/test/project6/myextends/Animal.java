package com.itoyon.tapp.common.test.project6.myextends;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月16日 下午10:10:05
 */
public class Animal {
	String name;
	int age = 10;

	public void eat() {
		final int i = 2;
		// age = 20;
		System.out.println("动物可以吃东西" + getClass());
	}

	public Animal(int b) {
		// age = 30;
		System.out.println("Animal执行了！");
	}
}
