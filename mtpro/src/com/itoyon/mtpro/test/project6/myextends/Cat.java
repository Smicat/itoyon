package com.itoyon.mtpro.test.project6.myextends;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月16日 下午10:11:20
 */
public class Cat extends Animal {
	int age = 100;

	public Cat() {
		super(3);
		//age = 50;
		System.out.println("Cat执行了！");
	}


	/* (non-Javadoc)
	 * <p>Title: equals</p>
	 * <p>Description: </p>
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		if (age != other.age)
			return false;
		return true;
	}
	
}
