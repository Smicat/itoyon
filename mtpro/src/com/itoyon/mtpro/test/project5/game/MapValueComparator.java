package com.itooy.project5.game;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class MapValueComparator implements Comparator<Map.Entry<Player, String>> {

	public int compare(Entry<Player, String> me1, Entry<Player, String> me2) {
		return me1.getValue().compareTo(me2.getValue());
	}

}
