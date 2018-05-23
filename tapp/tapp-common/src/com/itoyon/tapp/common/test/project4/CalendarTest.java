package com.itoyon.tapp.common.test.project4;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月24日 下午10:23:14
 */
public class CalendarTest {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(calendar.YEAR);
		int month = calendar.get(calendar.MONTH) + 1;
		int day = calendar.get(calendar.DAY_OF_MONTH);
		int hour = calendar.get(calendar.HOUR_OF_DAY);
		int minute = calendar.get(calendar.MINUTE);
		int second = calendar.get(calendar.SECOND);

		System.out.println("当前时间：" + year + "-" + month + "-" + day + " "
				+ hour + ":" + minute + ":" + second);
		
		Date date = calendar.getTime();
		long time = calendar.getTimeInMillis();
		System.out.println("当前时间：" + date);
		System.out.println("当前毫秒数：" + time);
		
	}
}
