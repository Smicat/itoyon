package com.itoyon.mtpro.test.project5;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年5月7日 下午10:22:05
 */
public class TestGeneric {
	public List<Course> courses;

	public TestGeneric() {
		courses = new ArrayList<Course>();
	}

	public void add() {
		Course course = new Course(1, "大学语文");
		courses.add(course);
		Course course2 = new Course(2, "Java基础");
		courses.add(course2);
	}

	public void foreach() {
		System.out.println("有如下课程待选：");
		for (Course course : courses) {
			System.out.println(course.id + ":" + course.name);
		}
	}
	
	public void testChild() {
		ChildCourse childCourse = new ChildCourse();
		childCourse.id=3;
		childCourse.name="我是子类型的课程对象实例";
		courses.add(childCourse);
	}

	public static void main(String[] args) {
		TestGeneric testGeneric = new TestGeneric();
		testGeneric.add();
		testGeneric.foreach();
		testGeneric.testChild();
		testGeneric.foreach();
	}
}
