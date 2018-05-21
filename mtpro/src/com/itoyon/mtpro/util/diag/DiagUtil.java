package com.itoyon.mtpro.util.diag;

import java.sql.SQLException;

/**
 * 
 * @Description: 诊断数据处理工具类
 * @author: Stone
 * @date: 2018年5月20日 下午10:19:49
 */
public class DiagUtil {

	// private static final int ROWS = 100;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String[] arrDiag = { "慢性 胃炎？，脑血管意外？", "感冒+消化不良？", "TIA，颈椎病", "闭经.内分泌不调", "胃动力不足（胃炎）", "肠炎（痢疾）？", "痔疮（混合痔？）", "70岁，心机缺血？",
				"1痛经 2 妇科炎症？", "1 高血压病 2眼皮浮肿待查", "“滴虫性阴道炎”", "1 腹痛待查 ？ 2肠痉挛？ 3 结石", "贫血（缺铁性贫血？）", "高血压2级", "1 高血压 冠心病", "测试-上感", "HP(+)",
				"颈肩综合征（未咨询完挂机，骚扰）", "头晕待诊：体位性低血压？脑血管供血不足？", "腹胀待诊：慢性胃炎？胆囊炎？", "糖尿病:糖尿病2型|高血压:50KG|慢性鼻炎", "1 中耳炎 2 胃炎", "1高血压病？2冠心病？",
				"颈椎病（混合型）", "高血压病、糖尿病、肾功不全？", "阑尾炎术后。急性胃炎？", "咽痛原因待诊：急性咽喉炎？", "1.腰椎间盘突出症 2.泌尿系感染", "慢性鼻-鼻窦炎", "1骨关节炎2中医诊断：痹证", "咨询---湿疹",
				"1、高血压病 2、2型糖尿病", "1、高血压病2、2型糖尿病", "“拔牙”术后？", "1.2型糖尿病 2.高血压病", "1.2型糖尿病2.高血压病", "1.高血压病2级（极高危）2.脑梗塞", "2型 糖尿病；",
				"\"鼻部手术\"术后?", "1级高血压，2型糖尿病，3冠心病", "1级\"高血压\"，2型糖尿病，3冠心病" };

		// String[] arrDiag = new String[ROWS];
		//
		// JDBCUtil jdbcUtil = new JDBCUtil();
		// Connection connection = jdbcUtil.doConnet();
		// if (!connection.isClosed()) {
		// ResultSet rs = jdbcUtil.doQuery("select init_diag from t_init_diag
		// limit " + ROWS + ";");
		// String initDiag = null;
		// int count = 0;
		// BitUtil bitConvert = new BitUtil();
		//
		// while (rs.next()) {
		// initDiag = rs.getString("init_diag");
		// arrDiag[count] = bitConvert.widthFullToHalf(initDiag);
		// count++;
		// }
		// jdbcUtil.doClose();
		//
		// DiagUtil diagUtil = new DiagUtil();
		// String resultStr = null;
		// String matchStr = null;
		//
		// for (int i = 0; i < arrDiag.length; i++) {
		// resultStr = diagUtil.noiseWordsFilter(arrDiag[i]);
		// matchStr = diagUtil.matchDoubleQuot(resultStr);
		// if (null == matchStr) {
		// matchStr = diagUtil.matchINumtem(arrDiag[i]);
		// }
		// System.out.println(arrDiag[i] + " ■ " + resultStr + " ■ " +
		// matchStr);
		// System.out.println("--------------------------------------------------------------------------------------------------");
		// }
		//
		// }
		DiagUtil diagUtil = new DiagUtil();
		String resultStr = null;
		String matchStr = null;

		for (int i = 0; i < arrDiag.length; i++) {
			matchStr = diagUtil.matchNumItem(arrDiag[i]);
			matchStr = diagUtil.matchDoubleQuot(matchStr);
			resultStr = diagUtil.noiseWordsFilter(matchStr);
			System.out.println(arrDiag[i] + "  ■  " + resultStr + "  ■  " + matchStr);
			System.out.println("--------------------------------------------------------------------------------------------------");
		}

	}

	/**
	 * 
	 * @Title: noiseWordsFilter @Description: 噪声字过虑 @param @param
	 *         src @param @return 设定文件 @return String 返回类型 @throws
	 */
	public String noiseWordsFilter(String src) {
		if (null == src) {
			return null;
		}
		src = src.trim();
		if (0 == src.length()) {
			return null;
		}

		StringBuffer result = new StringBuffer();
		String[] strs = new String[src.length()];
		char[] chars = src.toCharArray();
		int asciiInt = 0;
		String tmp = null;

		for (int i = 0; i < chars.length; i++) {
			asciiInt = (int) chars[i];

			/**
			 * <PRE>
			 * Unicode范围：
			 * "：34 
			 * (：40
			 * )：41
			 * -（短横线）：45 
			 * 数字：48-57 
			 * :（冒号）：58 
			 * 大写字母：65-90 
			 * 小写字母：97-122
			 * |（竖线）：124 
			 * 基本汉字：19968-40869
			 * </PRE>
			 */
			if (asciiInt == 34 || asciiInt == 40 || asciiInt == 41 || asciiInt == 45 || asciiInt == 58 || asciiInt == 124
					|| (asciiInt >= 48 && asciiInt <= 57) || (asciiInt >= 65 && asciiInt <= 90) || (asciiInt >= 97 && asciiInt <= 122)
					|| (asciiInt >= 19968 && asciiInt <= 40869) || (asciiInt >= 48 && asciiInt <= 58)) {
				tmp = String.valueOf(chars[i]);
			} else {
				if (i > 0 && i < chars.length - 1) {
					if (strs[i - 1] == "|" || strs[i - 1] == "") {
						tmp = "";
					} else {
						tmp = "|";
					}
				} else {
					tmp = "";
				}
			}
			result.append(tmp);
			strs[i] = tmp;
		}

		return result.toString();
	}

	/**
	 * 匹配数字条目（如“1.xxx, 2.xxx ...”）
	 * 
	 * @param src
	 * @return
	 */
	public String matchNumItem(String src) {
		if (null == src) {
			return null;
		}

		String[] arrItem = { "1", "2", "3" };
		StringBuilder sb = new StringBuilder(src);
		String result = null;
		String tmp = null;
		int index = -1;

		if (sb.toString().matches("^[1-3]{1}.*[1-3]?.*[1-3]?.*$")) {
			for (int i = 0; i < arrItem.length; i++) {
				index = sb.indexOf(arrItem[i]);
				if (index != -1) {
					if (index < sb.length() - 2) {
						tmp = sb.substring(index + 1, index + 2);
						if (!tmp.equals("型") && !tmp.equals("级") && !tmp.equals("岁")) {
							sb.replace(index, index + 1, "");
						}
					}
					index = -1;
				}
			}
		}

		result = sb.toString();

		return result;
	}

	/**
	 * 匹配双引号
	 * 
	 * @param src
	 * @return
	 */
	public String matchDoubleQuot(String src) {
		if (null == src) {
			return null;
		}

		String result = null;

		if (src.matches("^.*\\\"+.*\\\"+.*$")) {
			result = src.replace("\"", "");
		} else {
			result = src;
		}

		return result;
	}

}
