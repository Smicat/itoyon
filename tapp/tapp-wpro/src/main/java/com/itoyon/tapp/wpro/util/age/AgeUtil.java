package com.itoyon.tapp.wpro.util.age;

import java.text.DecimalFormat;

public class AgeUtil {

	/**
	 * 全角对应于ASCII表的可见字符从！开始，偏移值为65281
	 */
	private static final char SBC_CHAR_START = 65281; // 全角！

	/**
	 * 全角对应于ASCII表的可见字符到～结束，偏移值为65374
	 */
	private static final char SBC_CHAR_END = 65374; // 全角～

	/**
	 * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
	 */
	private static final int CONVERT_STEP = 65248; // 全角半角转换间隔

	/**
	 * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理
	 */
	private static final char SBC_SPACE = 12288; // 全角空格 12288

	/**
	 * 半角空格的值，在ASCII中为32(Decimal)
	 */
	private static final char DBC_SPACE = ' '; // 半角空格

	private static final int MAX_AGE = 120; // 最大年龄

	public static void main(String[] args) {
		String s = "一岁零2个月";
		System.out.println(new AgeUtil().getAge(s, MAX_AGE));
	}

	public String getAge(String src, int maxAge) {
		String result = "0";
		int countYear;
		int countMonth;
		int countDay;
		String strYear;
		String strMonth;
		String strDay;
		float ftYear;
		float ftMonth;
		float ftDay;

		try {
			if (src == null) {
				return result;
			}

			// 全角转为半角
			src = this.widthFullToHalf(src);

			if (src.length() == 0) {
				return result;
			}

			countYear = src.indexOf("岁");
			countMonth = src.indexOf("月");
			countDay = src.indexOf("天");
			DecimalFormat df = new DecimalFormat("0.0");

			if (countYear == -1 && countMonth == -1 && countDay != -1) { // “x岁x月v天”
				strDay = src.substring(0, countDay);
				ftDay = this.getNum(strDay);
				if (ftDay >= 0 && ftDay <= (maxAge / 365)) {
					result = df.format(ftDay / 365);
				}
			} else if (countYear != -1 && countMonth == -1) { // “v岁x月v天”或“v岁x月x天”
				strYear = src.substring(0, countYear);
				ftYear = this.getNum(strYear);
				if (ftYear >= 0 && ftYear <= maxAge) {
					result = df.format(ftYear);
				}
			} else if (countYear == -1 && countMonth != -1) { // “x岁v月v天”或“x岁v月x天”
				strMonth = src.substring(0, countMonth);
				ftMonth = this.getNum(strMonth);
				if (ftMonth >= 0 && ftMonth <= (maxAge * 12)) {
					result = df.format(ftMonth / 12);
				}
			} else if ((countYear != -1 && countMonth != -1 && countDay == -1 && countYear < countMonth)
					|| (countYear != -1 && countMonth != -1 && countDay != -1 && countYear < countMonth && countMonth < countDay)) {
				ftYear = this.getNum(src.substring(0, countYear));
				ftMonth = this.getNum(src.substring(countYear + 1, countMonth - countYear + 2));
				if (ftYear >= 0 && ftYear <= maxAge) {
					if (ftMonth > 0 && ftMonth < 12) {
						result = String.valueOf(Math.round(ftYear)) + "." + String.valueOf(Math.round(ftMonth / 12 * 10));
					} else if (ftMonth >= 12) {
						ftYear = ftYear + Float.parseFloat(df.format(ftMonth / 12));
						if (ftYear >= 0 && ftYear <= maxAge) {
							result = df.format(ftYear);
						}
					} else {
						result = df.format(ftYear);
					}
				}
			} else if (countYear == -1 && countMonth == -1 && countDay == -1) { // “x岁x月x天”
				ftYear = this.getNum(src);
				if (ftYear >= 0 && ftYear <= maxAge) {
					result = df.format(ftYear);
				} else if (ftYear >= maxAge && ftYear <= (maxAge * 12)) {
					result = df.format(ftYear / 12);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public float getNum(String src) {
		float result = 0.0F;
		String tmp = "";
		int num;

		try {
			src = src.trim();
			if (src == null || "".equals(src)) {
				return result;
			}
			num = src.length();
			for (int i = 0; i < num; i++) {
				if ((src.charAt(i) >= 48 && src.charAt(i) <= 57) || src.charAt(i) == 46) {
					tmp += src.charAt(i);
				}
			}

			tmp = this.trimBoth(tmp, ".");
			if ("".equals(tmp) || null == tmp) {
				return result;
			}

			if (tmp.split(".").length > 1) {
				tmp = tmp.substring(0, tmp.indexOf(".") + 1);
			}

			result = tmp == null ? 0.0F : Float.parseFloat(tmp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int chnNumber2Int(String chnNumber) {
		int result = 0;
		int temp = 1;// 存放一个单位的数字如：十万
		int count = 0;// 判断是否有chArr
		char[] cnArr = new char[] { '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		char[] chArr = new char[] { '十', '百', '千', '万', '亿' };
		for (int i = 0; i < chnNumber.length(); i++) {
			boolean b = true;// 判断是否是chArr
			char c = chnNumber.charAt(i);
			for (int j = 0; j < cnArr.length; j++) {// 非单位，即数字
				if (c == cnArr[j]) {
					if (0 != count) {// 添加下一个单位之前，先把上一个单位值添加到结果中
						result += temp;
						temp = 1;
						count = 0;
					}
					// 下标+1，就是对应的值
					temp = j + 1;
					b = false;
					break;
				}
			}
			if (b) {// 单位{'十','百','千','万','亿'}
				for (int j = 0; j < chArr.length; j++) {
					if (c == chArr[j]) {
						switch (j) {
						case 0:
							temp *= 10;
							break;
						case 1:
							temp *= 100;
							break;
						case 2:
							temp *= 1000;
							break;
						case 3:
							temp *= 10000;
							break;
						case 4:
							temp *= 100000000;
							break;
						default:
							break;
						}
						count++;
					}
				}
			}
			if (i == chnNumber.length() - 1) {// 遍历到最后一个字符
				result += temp;
			}
		}
		return result;
	}

	public String widthFullToHalf(String src) {
		if (src == null) {
			return null;
		}
		StringBuilder buf = new StringBuilder(src.length());
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
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
	public String trimBoth(String src, String beTrim) {
		try {
			if (src == null) {
				return null;
			}

			src = src.trim();
			if (src.length() == 0) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return src;
	}
}