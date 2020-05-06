package util;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

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

    private static String[] UPPER_UNIT = {
            "零"	,"拾","佰","仟","萬","亿"
    };

    private static String[] CURRENCY_UNIT = {"元","角","分"};

    private static String UPPER_RESULT; // 大写转换结果
    private static String LOWER_RESULT; // 小写转换结果

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

        String left = doIntegerPart(number_ls[0]);
        String right = doDecimalPart(number_ls[1]);

        System.out.println("输出: " + left + "圆 " + right);
        return left + "圆 " + right;
    }

    public static String doIntegerPart(String integer) {

        int count;
        boolean flag = true;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i<integer.length(); i++) {

            if (integer.charAt(i) == '0') {
                if (flag)
                    result.append("零");
                flag = false;
                continue;
            }

            flag = true;
            result.append(UPPER_CASE[Integer.valueOf(String.valueOf(integer.charAt(i))) - 1]);

            count = integer.length() - i;
            result.append(doDigit(count));
        }
        return result.toString();
    }

    /**
     * 根据一个数的位数，返回对应的单位. 输入10,返回 拾亿
     * @param count
     * @return
     */
    private static String doDigit(int count) {
        if (count <= 1)
            return "";

        int difference; //差值
        int i;
        for (i = UPPER_UNIT.length-1; i>=1; i--) {
            difference = WEIGHT.get(UPPER_UNIT[i]);
            if (count >= difference) {
                count -= difference;
                break;
            }
        }
        return doDigit(count) + UPPER_UNIT[i];
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
            // todo bug待处理，数值显示不正确
            number2words("32000000.97");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
