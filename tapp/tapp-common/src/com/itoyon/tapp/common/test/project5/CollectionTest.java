package com.itoyon.tapp.common.test.project5;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月25日 下午9:21:43
 */
public class CollectionTest {
	public static void main(String[] args) {
		Map<String, Object> imap = new HashMap<String, Object>();
		imap.put("1", "小红");
		imap.put("2", "小明");
		imap.put("3", "小兰");

		System.out.println("imap中是否包含key为1的值：" + imap.containsKey("1"));
		System.out.println("imap中是否包含value为'小红'的值：" + imap.containsValue("小红"));
	}
}
