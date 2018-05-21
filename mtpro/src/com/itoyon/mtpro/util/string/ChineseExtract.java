package com.itoyon.mtpro.util.string;

public class ChineseExtract {
	/**
	 * 从字符串中提取纯汉字
	 *
	 * @param src
	 * @return
	 */
	private static String extractCHN(String src) {
		String result = "";
		boolean flag = false;

		if (src == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < src.length(); i++) {
			char c = src.charAt(i);
			flag = isChinese(c);
			if (flag) {
				sb.append(c);
			}
		}
		result = sb.toString();

		return result;
	}

	/**
	 * 判断字符是否为汉字
	 *
	 * @param src
	 * @return
	 */
	private static boolean isChinese(char src) {
		boolean isGB2312 = false;
		byte[] bytes = ("" + src).getBytes();
		if (bytes.length == 3) {
			int[] ints = new int[2];
			ints[0] = bytes[0] & 0xff;
			ints[1] = bytes[1] & 0xff;

			if (ints[0] >= 0x81 && ints[0] <= 0xFE && ints[1] >= 0x40 && ints[1] <= 0xFE) {
				isGB2312 = true;
			}
		}
		return isGB2312;
	}

	public static void main(String[] args) {
		String s = "%$&二岁#$<>4个月";
		System.out.println(s);
		System.out.println(ChineseExtract.extractCHN(s));
	}
}
