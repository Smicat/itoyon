package com.itoyon.tapp.wpro.util.cryptCode;

import java.io.UnsupportedEncodingException;

public class EncodeUtil {
	public static final String ISO_8859_1 = "ISO-8859-1";
	public static final String UTF_8 = "UTF-8";

	/** 将字符编码转换成UTF-8 */
	public String toUTF_8(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_8);
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换的字符串
	 * @param newCharset
	 *            目标编码
	 */
	public String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
		if (str != null) {
			// 用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			return new String(bs, newCharset); // 用新的字符编码生成字符串
		}
		return null;
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换的字符串
	 * @param oldCharset
	 *            源字符集
	 * @param newCharset
	 *            目标字符集
	 */
	public String changeCharset(String str, String oldCharset, String newCharset) throws UnsupportedEncodingException {
		if (str != null) {
			// 用源字符编码解码字符串
			byte[] bs = str.getBytes(oldCharset);
			return new String(bs, newCharset);
		}
		return null;
	}
}
