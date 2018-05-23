package com.itoyon.tapp.common.test.project4;

import java.util.Arrays;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月22日 下午10:25:27
 */
public class StringTest {

	public static void main(String[] args) {
		String str = "学习 Java 编程";
		char c = '编';
		
		System.out.println("字符\"" + c +  "\"的位置：" + str.indexOf(c));
		
		System.out.println("字符串\"Java\"的位置：" + str.indexOf("Java"));
		
		String[] arr = str.split(" ");
		System.out.println("按空格拆分数组：" + Arrays.toString(arr));
		
		System.out.println("获取位置[3, 7) 之间的子串：" + str.substring(3, 7));
		
		System.out.println("获取索引为1位置的字符：" + str.charAt(1));
		
		byte[] b = str.getBytes();
		System.out.println("转换为字节数组：");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		
		String str2 = new String("学习 Java 编程");
		System.out.println("str和str2的内存地址相同？" + (str==str2));
		System.out.println("str和str2的内容相同？" + str.equals(str2));
		
	}

}
