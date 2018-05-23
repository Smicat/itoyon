package com.itoyon.tapp.common.test.project6;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月15日 下午5:50:37
 */
public class HelloWorld {
	int num1;
	int num2;
	static int num3;

	public HelloWorld() {
		num1 = 21;
		System.out.println("通过构造方法为变量num1赋值123");
	}

	{
		num1 = 73;
		System.out.println("通过初始化块为变量num1赋值456");
	}
	static {
		HelloWorld hWorld = new HelloWorld();
		hWorld.num1= 35;
		System.out.println("通过静态初始化块为变量num1赋值789");
	}

	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		System.out.println("num1=" + hw.num1);
		HelloWorld hw2 = new HelloWorld();
		System.out.println("num1=" + hw.num1);
		
		Person person = new Person("猪哥亮");
		person.name = "";
	}
}
