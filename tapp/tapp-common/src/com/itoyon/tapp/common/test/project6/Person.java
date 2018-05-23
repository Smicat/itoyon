package com.itoyon.tapp.common.test.project6;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月15日 下午4:55:27
 */
public class Person {
	protected String name;
	String sex;
	int age;

	public Person(String sName) {
		name = sName;
		System.out.println("调用了有参构造方法，且对成员变量name赋值了，其值为：" +name);
	}
	public Person(String sName, String sSex) {
		name = sName;
		sex = sSex;
		System.out.println("调用了有参构造方法，且对成员变量name和sex赋值了，值分别为：name=" +name + "，sex=" +sex);
	}
}
