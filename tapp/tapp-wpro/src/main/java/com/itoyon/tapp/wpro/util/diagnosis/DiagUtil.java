package com.itoyon.tapp.wpro.util.diagnosis;

import com.itoyon.tapp.wpro.util.string.BitUtil;

import java.sql.SQLException;

/**
 * @Description: 诊断数据处理工具类
 * @author: Stone
 * @date: 2018年5月20日 下午10:19:49
 */
public class DiagUtil {

    private static final int ROWS = 1000;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        String[] arrDiag = new String[ROWS];
//
//        JDBCUtil jdbcUtil = new JDBCUtil();
//        Connection connection = jdbcUtil.doConnet();
//        if (!connection.isClosed()) {
//            ResultSet rs = jdbcUtil.doQuery("select init_diag from t_init_diag limit " + ROWS + ";");
//            String initDiag = null;
//            int count = 0;
//            BitUtil bitUtil = new BitUtil();
//
//            while (rs.next()) {
//                initDiag = rs.getString("init_diag");
//                arrDiag[count] = bitUtil.widthFullToHalf(initDiag);
//                count++;
//            }
//            jdbcUtil.doClose();
//
//            DiagUtil diagUtil = new DiagUtil();
//            String resultStr;
//            String tmpStr;
//
//            long st = System.currentTimeMillis();
//            for (int i = 0; i < arrDiag.length; i++) {
//                tmpStr = bitUtil.widthFullToHalf(arrDiag[i]);
//                tmpStr = diagUtil.matchItemNo(tmpStr);
//                tmpStr = diagUtil.matchDoubleQuot(tmpStr);
//                tmpStr = diagUtil.matchHyphen(tmpStr);
//                tmpStr = diagUtil.matchBrackets(tmpStr);
//                tmpStr = diagUtil.matchSpace(tmpStr);
//                resultStr = diagUtil.noiseWordsFilter(tmpStr);
//                System.out.println(arrDiag[i] + "  ■  " + resultStr);
//                System.out.println("--------------------------------------------------------------------------------------------------");
//            }
//            long et = System.currentTimeMillis();
//            System.out.println("执行耗时：" + (et - st) + "ms");
//
//        }

        String[] arrDiag = {"慢性 胃炎？，脑血管意外？", "感冒+消化不良？", "TIA，颈椎病", "闭经.内分泌不调", "胃动力不足（胃炎）", "肠炎（痢疾）？", "痔疮（混合痔？）", "70岁，心机缺血？",
                "1痛经 2 妇科炎症？", "1 高血压病 2眼皮浮肿待查", "“滴虫性阴道炎”", "1 腹痛待查 ？ 2肠痉挛？ 3 结石", "贫血（缺铁性贫血？）", "高血压2级", "1 高血压 冠心病", "测试-上感", "HP(+)",
                "颈肩综合征（未咨询完挂机，骚扰）", "头晕待诊：体位性低血压？脑血管供血不足？", "腹胀待诊：慢性胃炎？胆囊炎？", "糖尿病:糖尿病2型|高血压:50KG|慢性鼻炎", "1 中耳炎 2 胃炎", "1高血压病？2冠心病？",
                "颈椎病（混合型）", "高血压病、糖尿病、肾功不全？", "阑尾炎术后。急性胃炎？", "咽痛原因待诊：急性咽喉炎？", "1.腰椎间盘突出症 2.泌尿系感染", "慢性鼻-鼻窦炎", "1骨关节炎2中医诊断：痹证", "咨询---湿疹",
                "1、高血压病 2、2型糖尿病", "1、高血压病2、2型糖尿病", "“拔牙”术后？", "2型 糖尿病；", "\"鼻部手术\"术后?", "1级高血压，2型糖尿病，3冠心病", "1级\"高血压\"，2型糖尿病，3冠心病",
                "1.2型糖尿病 2.高血压病", "1.2型糖尿病2.高血压病", "1.高血压病2级（极高危）2.脑梗塞", "慢性  咽喉炎急性期", "急性咽炎    急性肠炎    慢性 胃炎", "慢性 鼻炎急性 发作", "急性 咽喉炎 慢性 鼻炎",
                "\"胃脘痛病:47kg", "咽炎()", "(12.5kg小孩)急性支气管炎(支原体感染)", "1、", "1、炎", "1、高血压 2、", "(Ⅱ型糖尿病", "(肝郁脾虚);心阴不足,入睡困难、早醒?", ",1,高血压病2脑出血后遗症,",
                ",1,慢性支气管炎急性发作,2,急性扁桃体炎", "、1、糖尿病。2支气管炎"};

        BitUtil bitUtil = new BitUtil();
        DiagUtil diagUtil = new DiagUtil();
        String resultStr;
        String tmpStr;

        long st = System.currentTimeMillis();
        for (int i = 0; i < arrDiag.length; i++) {
            tmpStr = bitUtil.widthFullToHalf(arrDiag[i]);
            tmpStr = diagUtil.matchItemNo(tmpStr);
            tmpStr = diagUtil.matchDoubleQuot(tmpStr);
            tmpStr = diagUtil.matchHyphen(tmpStr);
            tmpStr = diagUtil.matchBrackets(tmpStr);
            tmpStr = diagUtil.matchSpace(tmpStr);
            resultStr = diagUtil.noiseWordsFilter(tmpStr);
            System.out.println(arrDiag[i] + "  ■  " + resultStr);
            System.out.println("--------------------------------------------------------------------------------------------------");
        }
        long et = System.currentTimeMillis();
        System.out.println("执行耗时：" + (et - st) + "ms");

    }

    /**
     * @Title: noiseWordsFilter @Description: 噪声字过虑 @param @param
     * src @param @return 设定文件 @return String 返回类型 @throws
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
        int asciiInt;
        String tmp;

        for (int i = 0; i < chars.length; i++) {
            asciiInt = (int) chars[i];

            /**
             * <PRE>
             * Unicode范围：
             * 34："
             * 40：(
             * 41：)
             * 45：-
             * 48-57：数字
             * 58：:
             * 65-90：A-Z
             * 97-122：a-z
             * 124：|
             * 19968-40869：基本汉字
             * </PRE>
             */
            if (asciiInt == 34 || asciiInt == 40 || asciiInt == 41 || asciiInt == 45 || asciiInt == 58 || asciiInt == 124
                    || (asciiInt >= 48 && asciiInt <= 57)
                    || (asciiInt >= 65 && asciiInt <= 90)
                    || (asciiInt >= 97 && asciiInt <= 122)
                    || (asciiInt >= 19968 && asciiInt <= 40869)) {
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
     * 匹配数字序号（如“1.xxx, 2.xxx ...”中的1和2）
     *
     * @param src
     * @return
     */
    public String matchItemNo(String src) {
        if (null == src) {
            return null;
        }

        String result;

        if (src.matches("^[1-3]{1}.+[1-3]?.*[1-3]?.*$")) {
            StringBuilder sb = new StringBuilder(src);
            String[] arrItem = {"1", "2", "3"};
            String tmp;
            int index;

            if (sb.length() < 3) {
                result = null;
            } else {
                for (int i = 0; i < arrItem.length; i++) {
                    index = sb.indexOf(arrItem[i]);
                    while (index >= 0 && index < sb.length()) {
                        tmp = sb.substring(index + 1, index + 2);
                        if (!tmp.equals("型") && !tmp.equals("级") && !tmp.equals("岁")) {
                            sb.replace(index, index + 1, " ");
                            index = sb.indexOf(arrItem[i], index + 2);
                        } else {
                            index = sb.indexOf(arrItem[i], index + 1);
                        }
                    }
                }
                result = sb.toString();
            }

        } else {
            result = src;
        }

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

        String result;

        if (src.matches("^.*\"+.*$")) {
            result = src.replace("\"", "");
        } else if (src.matches("^.*\\“+.*\\”+.*$")) {
            result = src.replace("“", "").replace("”", "");
        } else {
            result = src;
        }

        return result;
    }

    /**
     * 匹配连字符
     *
     * @param src
     * @return
     */
    public String matchHyphen(String src) {
        if (null == src) {
            return null;
        }

        String result;
        final String symbol = "-";

        if (src.matches("^.*\\-+.*$")) {
            StringBuilder sb = new StringBuilder(src);
            int index;
            int firstIndex;
            int count = 0;

            index = sb.indexOf(symbol);
            firstIndex = index;
            while (index >= 0 && index < sb.length()) {
                if (index == 0) {
                    sb.replace(index, index + 1, "");
                    index = sb.indexOf(symbol, index);
                    continue;
                } else if (index == sb.length() - 1) {
                    sb.replace(index, index + 1, "");
                    index = index - 1;
                    if (!sb.substring(index).equals(symbol)) {
                        break;
                    }
                    continue;
                } else {
                    if (count > 0) {
                        if (sb.substring(index - 1, index).equals(sb.substring(index, index + 1))) {
                            sb.replace(index - 1, index + 1, " ");
                        } else {
                            sb.replace(index, index + 1, "");
                        }

                        index = index - 1;
                        if (index < firstIndex) {
                            break;
                        }
                    }
                    index = sb.indexOf(symbol, index + 1);
                    count++;
                }
            }

            result = sb.toString();
        } else {
            result = src;
        }

        return result;
    }

    /**
     * 匹配括号
     *
     * @param src
     * @return
     */
    public String matchBrackets(String src) {
        if (null == src) {
            return null;
        }

        String result;

        while (src.matches("^.*\\(+.*\\)+.*$")) {
            result = src.substring(0, src.indexOf("(")) + src.substring(src.indexOf(")") + 1);
            src = result;
        }
        result = src;

        return result;
    }

    /**
     * 匹配空格
     *
     * @param src
     * @return
     */
    public String matchSpace(String src) {
        if (null == src) {
            return null;
        }

        String result;

        if (src.matches("^.*((型)+\\s+(糖尿病)+).*$")) {
            result = src.substring(0, src.indexOf("型") + 1) + src.substring(src.indexOf("糖尿病"));
        } else if (src.matches("^.*((级)+\\s+(高血压)+).*$")) {
            result = src.substring(0, src.indexOf("级") + 1) + src.substring(src.indexOf("高血压"));
        } else if (src.matches("^.*(慢性)+\\s+.+$")) {
            int index = src.indexOf("慢性") + 2;
            while (index > 0 && index < src.length() - 1
                    && src.substring(index, index + 1).equals(" ")) {
                index++;
            }

            result = src.substring(0, src.indexOf("慢性") + 2) + src.substring(index);
            src = result;

            if (src.matches("^.*(急性)+\\s+.+$")) {
                index = src.indexOf("急性") + 2;
                while (index > 0 && index < src.length() - 1
                        && src.substring(index, index + 1).equals(" ")) {
                    index++;
                }
                result = src.substring(0, src.indexOf("急性") + 2) + src.substring(index);
            }

        } else if (src.matches("^.*(急性)+\\s+.+$")) {
            int index = src.indexOf("急性") + 2;
            while (index > 0 && index < src.length() - 1
                    && src.substring(index, index + 1).equals(" ")) {
                index++;
            }
            result = src.substring(0, src.indexOf("急性") + 2) + src.substring(index);
            src = result;

            if (src.matches("^.*(慢性)+\\s+.+$")) {
                index = src.indexOf("慢性") + 2;
                while (index > 0 && index < src.length() - 1
                        && src.substring(index, index + 1).equals(" ")) {
                    index++;
                }
                result = src.substring(0, src.indexOf("慢性") + 2) + src.substring(index);
            }

        } else {
            result = src;
        }

        return result;
    }

}