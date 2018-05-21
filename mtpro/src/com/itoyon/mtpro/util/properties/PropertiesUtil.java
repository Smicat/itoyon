package com.itoyon.mtpro.util.properties;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static final String PROPERTIES = "config/config.properties";

	public static String getProperty(String keyWord) {
		Properties prop = new Properties();
		String value = null;
		try {
			File file = new File(PROPERTIES);
			FileInputStream fis = new FileInputStream(file);
			// 通过输入缓冲流进行读取配置文件
			InputStream InputStream = new BufferedInputStream(fis);
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
	}

}
