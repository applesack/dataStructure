package demo.zleetcodes.util;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月11日 9:41
 */
public class InputFilter {

    private static String OPERATORS = "+-/*^";

    /**
     * 过滤输入
     * @author 1806010814
     * @param rsl 已经有的输入
     * @param temp 新的输入
     * @return 返回过滤后的输入
     * @throws Exception 过滤过程中发现问题，抛出异常，假如出现异常，新的输入应该丢掉
     */
    public static String doFilter(String rsl, String temp) throws Exception {

        if (rsl.length() == 0 && temp.length() != 0)
            return temp;

        int len = rsl.length();

        if (temp.equals(")")) { // 假如新的输入是右括号，检查有没有左括号与之对应
            /**
             * 当有一个表达式: 12+()
             * 操作符"+"的左右两边都称为数据项，但是右边的"()"不是一个完整的数据项
             *      所以不能参与计算
             * 假如新的输入是")"，那么已有的输入不能以"("结尾!!
             */
            if (rsl.charAt(len - 1) == '(')
                throw new Exception("无效的数据项!!");

            Stack<Character> parentheses = new Stack<>();
            for (int i = 0; i<rsl.length(); i++) {
                char c_temp = rsl.charAt(i);
                if (c_temp == '(') {
                    parentheses.push(c_temp);
                } else if (c_temp == ')') {
                    if (parentheses.isEmpty() || parentheses.peek() != '(')

                        // 已有的输入: 已有的输入括号不匹配
                        throw new Exception("已有的输入括号不匹配");
                    else
                        parentheses.pop();
                }
            }

            // 括号匹配 将原有的输入和新的输入拼接返回,否则返回原有的输入
            if (parentheses.size() >= 1 && parentheses.peek() == '(')
                return rsl + temp;
            else
                return rsl;
        } else if (inList(temp, OPERATORS)) { // 假如新的输入是操作符
            /**
             * 对操作符 左边的操作数的要求
             * 假如已有的输入的末尾已经有操作符，则用新的操作符替换已有的操作符
             */
            if (inList(String.valueOf(rsl.charAt(len-1)), OPERATORS))
                return rsl.substring(0, len-1) + temp;

        } else if (ExpressionUtil.isNumber(temp)) { // 假如新的输入是数字
            if (ExpressionUtil.isLetter(String.valueOf(rsl.charAt(len-1)))) { // 选择函数之后直接输入了数字
                return rsl + "(" + temp;
            }

            return rsl + temp;
        } else if (temp.equals(".")) { // 新的输入是小数点
            // 小数点之前必须是数字
            if (ExpressionUtil.isNumber(String.valueOf(rsl.charAt(len-1))))
                return rsl + temp;
        } else if (ExpressionUtil.isLetter(temp)) { // 新的输入是函数/字符

            // 函数之前有数字，则在函数与数字之间用左括号隔开
            if (ExpressionUtil.isNumber(String.valueOf(rsl.charAt(len-1)))) {
                return rsl + "(" + temp;
            }
        }

        return rsl;
    }



    /**
     * 判断一个字符是否存在于字符串
     * @param aChar
     * @param str
     * @return
     */
    private static boolean inList(String aChar, String str) {
        if (aChar.length() > str.length())
            return false;

        for (int i = 0; i<str.length(); i++) {
            if (aChar.equals(String.valueOf(str.charAt(i))))
                return true;
        }
        return false;
    }

    @Test
    public void testThis() {
        try {
            String result = "";
            String temp = "2";

            result = doFilter(result, temp);

            System.out.println(ExpressionUtil.doExpression(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
