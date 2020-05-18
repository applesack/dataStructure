package leetcodes.util;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月06日 19:52
 */
public class AmountInWordsUtil {
    /**
     * 数字转大写金额
     */

    private static HashMap<String, Integer> WEIGHT;

    // 大写数字
    private static String[] UPPER_CASE = {
            "壹","贰","叁","肆","伍","陆","柒","捌","玖"
    };

    // 大写单位
    private static String[] UPPER_UNIT = {
            "零"	,"拾","佰","仟","萬","亿","萬",""
    };

    // 大写货币单位
    private static String[] CURRENCY_UNIT = {"元","角","分"};

    static {
        WEIGHT = new HashMap<>();
        WEIGHT.put(UPPER_UNIT[1], 2);
        WEIGHT.put(UPPER_UNIT[2], 3);
        WEIGHT.put(UPPER_UNIT[3], 4);
        WEIGHT.put(UPPER_UNIT[4], 5);
        WEIGHT.put(UPPER_UNIT[5], 9);
    }

    public static String number2words(String numberStr) throws Exception {

        System.out.println("输入: " + numberStr);

        if (numberStr.indexOf(".") == -1)
            return doIntegerPart(numberStr) + " 圆整";

        String[] number_ls = numberStr.split("\\.");
        if (number_ls.length > 2)
            throw new Exception("请检查要转换成大写的数字是否包含超过一个小数点: " + numberStr);

        if (number_ls[0].length() > 16)
            throw new Exception("数目过于巨大: " + number_ls[0].length() + "位");

        String left = doIntegerPart(number_ls[0]);
        String right = doDecimalPart(number_ls[1]);

        return left + "圆 " + right;
    }

    /**
     * 将一个整数字符串转换成中文大写
     * @param integer 要处理的字符串
     * @return
     */
    private static String doIntegerPart(String integer) {

        int index = 0;
        String integer_str = integer;
        String temp;
        StringBuffer result_str = new StringBuffer();

        // 为了方便处理，把要处理的字符串在前面补0
        if (integer.length()%4 != 0) {
            for (index = 0; index<(4 - integer.length()%4); index++) {
                integer_str = "0" + integer_str;
            }
        }

        // 4个一组来处理, 用一个变量来存储当前是第几组
        int group_index;
        for (index = 0; index<(integer_str.length()/4); index++) {
            temp = integer_str.substring(4*index, 4*index+4);

            result_str.append(doDigitIn1to4(temp));

            group_index = (integer_str.length()/4) - index;
            // 假如当前处理的4个字符不是最低位则加上单位
            if (group_index > 1) {
                // index 1:万 2:亿
                result_str.append(UPPER_UNIT[group_index + 2]);
            }
        }

        // 减去最前面的零
        if (result_str.toString().startsWith("零")) {
            return result_str.substring(1, result_str.length());
        }

        return result_str.toString();
    }

    /**
     * 根据一个数的位数，返回形容这个位数的最大单位的下标.
     * @param num
     * @return
     */
    private static String doDigitIn1to4(String num) {
        String number = num;
        if (number.length() < 4) {
            for (int i = 0; i<4-number.length(); i++)
                number = "0" + number;
        }

        StringBuffer resultStr = new StringBuffer();
        String temp;
        boolean flag = false;
        for (int i = 0; i<number.length(); i++) {
            temp = String.valueOf(number.charAt(i));
            if (temp.equals("0")) {
                flag = true;
                continue;
            }

            if (flag)
                resultStr.append("零");
            flag = false;

            resultStr.append(UPPER_CASE[Integer.valueOf(String.valueOf(number.charAt(i))) - 1]);

            if (i == number.length()-1) continue; // 假如当前的数字是最后一位，则不带单位

            resultStr.append(UPPER_UNIT[3-i]);
        }
        return resultStr.toString();
    }

    /**
     * 处理小数部分，把小数转换成大写
     * @param decimal
     * @return
     * @throws Exception
     */
    private static String doDecimalPart(String decimal) throws Exception {
        if (decimal.length() > 2)
            throw new Exception("小数部分不能超过两位: " + decimal);

        StringBuffer transfer = new StringBuffer();
        String temp;
        for (int i = 0; i<decimal.length(); i++) {
            temp = String.valueOf(decimal.charAt(i));
            if (temp.equals("0"))
                continue;

            transfer.append(UPPER_CASE[Integer.valueOf(temp)-1]);
            transfer.append(CURRENCY_UNIT[i+1]);
        }
        return transfer.toString();
    }

    @Test
    public void testThis() {

        try {
//            number2words("33333333.97");
//            System.out.println(doDigit(16));
//            System.out.println(doIntegerPart("1200001"));
//            System.out.println(doDigitIn1to4("1"));
//            System.out.println(doIntegerPart("1200001020000001"));
            String number = "100.12";
            System.out.println("输出: " + number2words(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
