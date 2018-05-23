package com.itoyon.tapp.wpro.util.properties;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static final String PROPERTIES_URL = "/config.properties";

	public static String getProperty(String keyWord) {
		Properties prop = new Properties();
		String value = null;
		try {
			// 通过输入缓冲流进行读取配置文件
			InputStream InputStream = PropertiesUtil.class.getResourceAsStream(PROPERTIES_URL);
			// 加载输入流
			prop.load(InputStream);
			// 根据关键字获取value值
			value = prop.getProperty(keyWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void main(String[] args) {
		String valueString = getProperty("JDBC_DRIVER");
		System.out.println(valueString);
		//Do something meaningful, keep exploring and innovating, until the end of our life.
	}

}
