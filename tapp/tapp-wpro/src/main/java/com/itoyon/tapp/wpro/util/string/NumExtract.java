package com.itoyon.tapp.wpro.util.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumExtract {

	/**
	 * ASCII表中可见字符从!开始，偏移位值为33(Decimal)
	 */
	static final char DBC_CHAR_START = 33; // 半角!

	/**
	 * ASCII表中可见字符到~结束，偏移位值为126(Decimal)
	 */
	static final char DBC_CHAR_END = 126; // 半角~

	/**
	 * 全角对应于ASCII表的可见字符从！开始，偏移值为65281
	 */
	static final char SBC_CHAR_START = 65281; // 全角！

	/**
	 * 全角对应于ASCII表的可见字符到～结束，偏移值为65374
	 */
	static final char SBC_CHAR_END = 65374; // 全角～

	/**
	 * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
	 */
	static final int CONVERT_STEP = 65248; // 全角半角转换间隔

	/**
	 * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理
	 */
	static final char SBC_SPACE = 12288; // 全角空格 12288

	/**
	 * 半角空格的值，在ASCII中为32(Decimal)
	 */
	static final char DBC_SPACE = ' '; // 半角空格

	public String getNum(String src) {
		String result = "";
		String tmp = null;
		int num = 0;

		src = src.trim();
		if (src == null || "".equals(src)) {
			return null;
		}
		num = src.length();
		for (int i = 0; i < num; i++) {
			if ((src.charAt(i) >= 48 && src.charAt(i) <= 57) || src.charAt(i) == 46) {
				result += src.charAt(i);
			}
		}

		result = this.trim(result, ".");
		if (result.contains(".")) {
			// tmp = result.substring(result.indexOf(".") + 1,
			// result.indexOf(".") + 2);
			// if ((".").equalsIgnoreCase(tmp)) {
			// result = result.substring(0, result.indexOf("."));
			// } else {
			// result = result.substring(0, result.indexOf(".") + 2);
			// }
			result = result.substring(0, result.indexOf("."));
		}

		return result;
	}

	public String widthFullToHalf(String src) {
		if (src == null) {
			return null;
		}
		StringBuilder buf = new StringBuilder(src.length());
		char[] ca = src.toCharArray();
		for (int i = 0; i < src.length(); i++) {
			if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) { // 如果位于全角！到全角～区间内
				buf.append((char) (ca[i] - CONVERT_STEP));
			} else if (ca[i] == SBC_SPACE) { // 如果是全角空格
				buf.append(DBC_SPACE);
			} else { // 不处理全角空格，全角！到全角～区间外的字符
				buf.append(ca[i]);
			}
		}
		return buf.toString();
	}

	/**
	 * 去除前后指定字符
	 *
	 * @param src
	 *            目标字符串
	 * @param beTrim
	 *            要删除的指定字符
	 * @return 删除之后的字符串
	 */
	public String trim(String src, String beTrim) {
		if (src == null) {
			return null;
		}

		src = src.trim();
		if (src == null) {
			return null;
		}

		// 循环去掉字符串首的beTrim字符
		String beginChar = src.substring(0, 1);
		while (beginChar.equalsIgnoreCase(beTrim)) {
			if (1 == src.length()) {
				return null;
			}
			src = src.substring(1, src.length());
			beginChar = src.substring(0, 1);
		}

		// 循环去掉字符串尾的beTrim字符
		String endChar = src.substring(src.length() - 1, src.length());
		while (endChar.equalsIgnoreCase(beTrim)) {
			src = src.substring(0, src.length() - 1);
			endChar = src.substring(src.length() - 1, src.length());
		}

		return src;
	}

	/**
	 * 获取指定字符串出现的次数
	 *
	 * @param src
	 *            源字符串
	 * @param findText
	 *            要查找的字符串
	 * @return
	 */
	public int appearNumber(String src, String findText) {
		int count = 0;
		Pattern p = Pattern.compile(findText);
		Matcher m = p.matcher(src);
		while (m.find()) {
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		NumExtract numExtract = new NumExtract();
		String str = ".12 3.6岁";
      System.out.println(str + " >> " + numExtract.getNum(numExtract.widthFullToHalf(str)));
	}
	
}