package com.itoyon.mtpro.test.project5.game;

/**
 * @Description: 扑克牌点数
 * @author: Stone
 * @date: 2018年5月13日 上午9:05:13
 */
public class Point {
	Integer id;
	String name;

	public Point() {
	}

	public Point(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
