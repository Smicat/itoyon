package com.itoyon.mtpro.test.poker;

import java.util.Comparator;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年5月13日 上午11:39:24
 */
public class PointComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		return o1.id.compareTo(o2.id);
	}

}
