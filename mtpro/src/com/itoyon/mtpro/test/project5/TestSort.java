package com.itoyon.mtpro.test.project5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年5月12日 下午8:52:46
 */
public class TestSort {
	public static void main(String[] args) {
		TestSort testSort = new TestSort();
		testSort.sort();
	}

	public void sort() {
		List<Student> studentList = new ArrayList<Student>();
		String[] stuName = {"Mike" , "Angela", "Lucy"};
		Student student = null;
		int count = 0;

		do {
			Integer tmp = Integer.valueOf(new Random().nextInt(1000));
			student = new Student(tmp, stuName[count]);
			studentList.add(student);
			count++;
		} while (studentList.contains(student) && count < 3);

		System.out.println("-------------排序前---------------");
		for (Student st : studentList) {
			System.out.println("学生：" + st.id + "，" + st.name);
		}
		
		System.out.println();
		
		//Collections.sort(studentList); // 按ID排序
		Collections.sort(studentList, new StudentComparator()); //按姓名排序
		System.out.println("-------------排序后---------------");
		for (Student st : studentList) {
			System.out.println("学生：" + st.id + "，" + st.name);
		}

	}
}
