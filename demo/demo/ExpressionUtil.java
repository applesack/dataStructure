package demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月05日 22:03
 */
public class ExpressionUtil {

    // 计算表达式字符串
    public static Double doExpression(String expressionStr) {

        return null;
    }

    /**
     * 将一个数组解析成可以继续计算的中缀表达式
     * @param expressionStr
     * @return
     */
    private static List<String> str2infix(String expressionStr) {

        List<String> result_list = new ArrayList<>();
        StringBuffer number_temp_ls = new StringBuffer();
        StringBuffer func_temp_ls = new StringBuffer();
        String transfer;

        for (int i = 0; i<expressionStr.length(); i++) {

            transfer = String.valueOf(expressionStr.charAt(i));

            if (!isLetter(transfer) && !isNumber(transfer)) {
                if (number_temp_ls.length() != 0)
                    result_list.add(number_temp_ls.toString());
                if (func_temp_ls.length() != 0)
                    result_list.add(func_temp_ls.toString());

                number_temp_ls.setLength(0);
                func_temp_ls.setLength(0);
            }

            if (isNumber(transfer)) {
                number_temp_ls.append(transfer);
            } else if (isLetter(transfer)) {
                func_temp_ls.append(transfer);
            } else {
                result_list.add(transfer);
            }
        }
        return result_list;
    }

    /**
     * 判断一个字符串是否可以被转换成数字
     * @param str 要匹配的字符串
     * @return 满足条件: 以数字开头 中间可以有小数点  假如中间有小数点，小数点后面必须是数字并且必须以数字结尾
     */
    private static boolean isNumber(String str) {
        return str.matches("^[0-9]+$|^[0-9]+[.]+[0-9]+$");
    }

    /**
     * 判断一个字符串是否是由字母构成
     * @param str 要匹配的字符串
     * @return 满足条件: 最少由一个大写或者小写字母构成
     */
    private static boolean isLetter(String str) {
        return str.matches("^[a-zA-Z]+$");
    }

    @Test
    public void test() {
        System.out.println(isNumber("22.1"));
        System.out.println(isLetter("awW"));
        System.out.println(str2infix("cos(123+11)"));
    }
}
