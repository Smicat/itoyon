package com.itoyon.mtpro.test.project5.game;

/**
 * @Description: 扑克牌花色
 * @author: Stone
 * @date: 2018年5月13日 上午9:05:13
 */
public class Face {
	Integer id;
	String name;

	public Face() {
	}

	public Face(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Face))
			return false;
		Face other = (Face) obj;
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
