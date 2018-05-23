package com.itoyon.tapp.common.test.project5;

import java.util.Comparator;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年5月12日 下午11:24:07
 */
public class StudentComparator implements Comparator<Student> {

	public int compare(Student o1, Student o2) {
		return o1.name.compareTo(o2.name);
	}
}
