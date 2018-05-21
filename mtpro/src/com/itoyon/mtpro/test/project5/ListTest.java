package com.itooy.project5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月25日 下午9:54:54
 */
public class ListTest {
	public List courseList;

	public ListTest() {
		this.courseList = new ArrayList();
	}

	public void testAdd() {
		Course course1 = new Course(1, "数据结构");
		courseList.add(course1);
		Course tmp = (Course) courseList.get(0);
		System.out.println("添加了课程：" + tmp.id + ", " + tmp.name);

		Course course2 = new Course(2, "C语言");
		courseList.add(0, course2);
		Course tmp2 = (Course) courseList.get(0);
		System.out.println("添加了课程：" + tmp2.id + ", " + tmp2.name);

		courseList.add(course1);
		Course tmp0 = (Course) courseList.get(2);
		System.out.println("添加了课程：" + tmp0.id + ", " + tmp0.name);

		Course[] courses = { new Course(3, "离散数学"), new Course(4, "汇编语言") };
		courseList.addAll(Arrays.asList(courses));
		Course tmp3 = (Course) courseList.get(3);
		Course tmp4 = (Course) courseList.get(4);
		System.out.println("添加了两门课程：" + tmp3.id + ", " + tmp3.name + "; "
				+ tmp4.id + ", " + tmp4.name);

		Course[] courses2 = { new Course(5, "高等数学"), new Course(6, "大学英语") };
		courseList.addAll(2, Arrays.asList(courses2));
		Course tmp5 = (Course) courseList.get(2);
		Course tmp6 = (Course) courseList.get(3);
		System.out.println("添加了两门课程：" + tmp5.id + ", " + tmp5.name + "; "
				+ tmp6.id + ", " + tmp6.name);
	}

	public void testGet() {
		int size = courseList.size();
		for (int i = 0; i < size; i++) {
			Course course = (Course) courseList.get(i);
			System.out.println("课程：" + course.id + ", " + course.name);
		}
	}

	public void testIterator() {
		Iterator iterator = courseList.iterator();
		System.out.println("有如下课程待选（通过迭代器访问）：");
		while (iterator.hasNext()) {
			Course course = (Course) iterator.next();
			System.out.println("课程：" + course.id + ", " + course.name);
		}
	}

	public void testForeach() {
		System.out.println("有如下课程待选（通过for each访问）：");
		for (Object object : courseList) {
			Course course = (Course) object;
			System.out.println("课程：" + course.id + ", " + course.name);
		}
	}

	public void testModify() {
		courseList.set(4, new Course(7, "线性代数"));
	}

	public void testRemove() {
		// Course course = (Course) courseList.get(4);
		// System.out.println("我是课程“" + course.id + ", " + course.name
		// + "”, 我即将被删除");
		// courseList.remove(course);

		// System.out.println("即将删除4位置上的课程");
		// courseList.remove(4);

		System.out.println("即将删除4位置和5位置上的课程");
		Course[] courses = { (Course) courseList.get(4),
				(Course) courseList.get(5) };
		courseList.removeAll(Arrays.asList(courses));

		System.out.println("成功删除课程！");
		testForeach();
	}

	public static void main(String[] args) {
		ListTest listTest = new ListTest();
		listTest.testAdd();
		listTest.testGet();
		listTest.testIterator();
		listTest.testForeach();
		listTest.testModify();
		listTest.testForeach();
		listTest.testRemove();
	}
}
