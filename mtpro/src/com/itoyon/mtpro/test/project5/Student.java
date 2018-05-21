package com.itooy.project5;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月25日 下午9:45:08
 */
public class Student implements Comparable<Student>{
	public Integer id;
	public String name;
	public Set<Course> courses;

	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}

	public int compareTo(Student o) {
		return this.id.compareTo(o.id);
	}

}
