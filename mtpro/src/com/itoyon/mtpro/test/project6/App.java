package com.itoyon.mtpro.test.project6;

import java.util.Arrays;

/**
 * Hello world!
 * 
 */
@SuppressWarnings("unused")
public class App {
	private static String hobby = "ityon, programing";
	String favorite =  "programing";
	
	public static void main(String[] args) {
		/*int[] scores = { 34, 45, 73, 69, 87, 83, 93, -28, 69, 95, 85, 34, 45,
				73, 69, 87, 83, 93, -28, 69, 95, 85, 34, 45, 73, 69, 87, 83,
				93, -28, 69, 95, 85, 34, 45, 73, 69, 87, 83, 93, -28, 69, 95,
				85, 34, 45, 73, 69, 87, 83, 93, -28, 69, 95, 85, 34, 45, 73,
				69, 87, 83, 93, -28, 69, 95, 85, 34, 45, 73, 69, 87, 83, 93,
				-28, 69, 95, 85, 34, 45, 73, 69, 87, 83, 93, -28, 69, 95, 85,
				34, 45, 73, 69, 87, 83, 93, -28, 69, 95, 85, 34, 45, 73, 69,
				87, 83, 93, -28, 69, 95, 85, 34, 45, 73, 69, 87, 83, 93, -28,
				69, 95, 85, 34, 45, 73, 69, 87, 83, 93, -28, 69, 95, 85, 34,
				45, 73, 69, 87, 83, 93, -28, 69, 95, 85, 34, 45, 73, 69, 87,
				83, 93, -28, 69, 95, 85, 34, 45, 73, 69, 87, 83, 93, -28, 69,
				95, 85, 34, 45, 73, 69, 87, 83, 93, -28, 69, 95, 85 };
		Arrays.sort(scores);
		System.out.println("对数组排序：" + Arrays.toString(scores));
		int count = 0;
		System.out.println("数组中排名前3的元素分别是：");
		float st = System.currentTimeMillis();
		for (int i = scores.length - 1; i >= 0; i--) {
			if (scores[i] < 0 || scores[i] > 100) {
				continue;
			}
			count++;
			if (count <= 3) {
				System.out.println(scores[i]);
			}
		}
		float et = System.currentTimeMillis();
		System.out.println("对数组排序共计耗时：" + (et - st) + "ms");*/
		
		/*System.out.println("通过类名访问hobby：" + App.hobby);
		App app = new App();
		System.out.println("通过对象名访问hobby：" + app.hobby);
		app.hobby = "篮球";
		System.out.println("通过类名访问hobby：" + App.hobby);
		System.out.println("通过对象名访问hobby：" + app.hobby);*/
		
		print();
		App app = new App();
		app.show();
	}
	
	public static void print() {
		System.out.println("---------调用print()方法---------");
		System.out.println("hobby：" + hobby);
		App app = new App();
		System.out.println("favorite：" + app.favorite);
		app.show();
	}
	
	public void show() {
		System.out.println("---------调用show()方法---------");
		System.out.println("hobby：" + hobby);
		System.out.println("favorite：" + favorite);
	}
}
