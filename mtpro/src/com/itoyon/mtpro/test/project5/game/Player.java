package com.itoyon.mtpro.test.project5.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年5月13日 上午9:03:35
 */
public class Player {
	public Integer id;
	public String name;
	public List<Card> cardList;

	public Player() {
		cardList = new ArrayList<Card>();
	}
}
