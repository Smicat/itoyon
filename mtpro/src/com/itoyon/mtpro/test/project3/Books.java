package com.itoyon.mtpro.test.project3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Description: <b>模拟借书系统</b><br>
 *               1、定义字符串数组保存图书信息<br>
 *               2、提示用户输入，分别按“书名”和“图书序号”查找图书<br>
 *               3、根据输入信息进行适当的异常处理<br>
 *               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a、如果输入类型错误，抛出“错误命令异常”，并提示重新输入<br>
 *               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b、如果书名不存在，抛出“图书不存在异常”，并提示重新输入<br>
 *               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c、如果图书序号超过字符串数组范围，抛出“图书不存在异常”，
 *               并提示重新输入<br>
 * @author: Stone
 * @date: 2018年4月19日 下午10:44:40
 */
public class Books {

	public static void main(String[] args) {
		String[] arrBooks = { "高数", "线性代数", "Java编程", "数据结构", "数据库设计" };
		input(arrBooks);
	}

	/**
	 * 
	 * @Title: control
	 * @Description: 控制输入输出流
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void input(String[] arrBooks) {
		int flag = 0;
		Scanner scanner = null;

		while (flag == 0) {
			try {
				System.out.println("输入命令：1-按照名称查找图书；2-按照序号查找图书");
				scanner = new Scanner(System.in);
				flag = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("输入命令错误！请根据提示输入数字命令！");
				flag = 0;
			}

			if (flag == 1) {
				String iptString = null;
				while (iptString == null) {
					try {
						System.out.println("输入图书名称：");
						scanner = new Scanner(System.in);
						iptString = scanner.next();
						if (Arrays.asList(arrBooks).contains(iptString)) {
							System.out.println("book：" + iptString);
							break;
						} else {
							System.out.println("图书不存在！");
							flag = 0;
							break;
						}
					} catch (InputMismatchException e) {
						System.out.println("输入命令错误！请根据提示输入数字命令！");
						flag = 0;
						break;
					}
				}
			} else if (flag == 2) {
				int iptInt = 0;
				while (iptInt == 0) {
					try {
						System.out.println("输入图书序号：");
						scanner = new Scanner(System.in);
						iptInt = scanner.nextInt();
						if (Arrays.asList(arrBooks).contains(arrBooks[iptInt])) {
							System.out.println("book：" + arrBooks[iptInt]);
							break;
						} else {
							System.out.println("图书不存在！");
							flag = 0;
							break;
						}
					} catch (InputMismatchException e) {
						System.out.println("输入命令错误！请根据提示输入数字命令！");
						flag = 0;
						break;
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("图书不存在！");
						flag = 0;
						break;
					}
				}
			} else {
				flag = 0;
			}
		}
		scanner.close();
	}
}