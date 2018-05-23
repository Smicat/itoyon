package com.itoyon.tapp.common.test.project6;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月15日 下午9:59:47
 */
public class Hello {
	// 外部类的私有属性name
	private String name = "imooc";

	// 外部类的成员属性
	int age = 20;

	// 外部类中的静态变量score
	private static int score = 84;

	// 成员内部类Inner
	public class Inner {
		String name = "爱慕课";

		// 内部类中的方法
		public void show() {
			System.out.println("外部类中的name：" + Hello.this.name);
			System.out.println("内部类中的name：" + name);
			System.out.println("外部类中的age：" + age);
		}
	}

	// 创建静态内部类
	public static class SInner {
		// 内部类中的变量score
		int score = 91;

		public void show() {
			System.out.println("访问外部类中的score：" + Hello.score);
			System.out.println("访问外部类中的age：" + (new Hello()).age);
			System.out.println("访问内部类中的score：" + score);
		}
	}

	// 测试成员内部类
	public static void main(String[] args) {

		/*
		 * // 创建外部类的对象 Hello o = new Hello();
		 * 
		 * // 创建内部类的对象 Inner inn = o.new Inner();
		 * 
		 * // 调用内部类对象的show方法 inn.show();
		 */

		SInner si = new SInner();
		si.show();

	}
}
