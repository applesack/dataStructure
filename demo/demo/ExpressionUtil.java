package demo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月05日 22:03
 */
public class ExpressionUtil {
    /**
     * 计算带有表达式的字符串
     * 例如
     *      "-2+3(6/2)"
     *      "log(5-2)^3"
     *      "ln(log(14))/5"
     * 计算结果Double类型，当表达式不可解析抛出异常
     */

    private static Double RESULT;

    // 计算表达式字符串
    public static Double doExpression(String expressionStr) throws Exception {

        List<String> infix = str2infix(expressionStr);
        System.out.println("中缀表达式" + infix.toString());

        List<String> temp = addOperator(infix);
        System.out.println("临时数组" + temp.toString());

        List<String> postfix = infix2postfix(temp);
        System.out.println("后缀表达式" + postfix.toString());

        RESULT = doPostfix(postfix);
        return RESULT;
    }

    /**
     * 处理后缀表达式
     * @param postfix_list
     * @return
     */
    private static Double doPostfix(List<String> postfix_list) throws Exception {

        Stack<Double> data_stack = new Stack<>();
        Double left;
        Double right;

        for (String item : postfix_list) {
            if (isNumber(item)) {
                data_stack.push(new Double(item));
            } else {
                item = item.toLowerCase();
                if (item.equals("+")) {                      // 加法
                    right = data_stack.pop();
                    left = data_stack.pop();
                    data_stack.push(left + right);
                } else if (item.equals("-")) {               // 减法
                    right = data_stack.pop();
                    left = data_stack.pop();
                    data_stack.push(left - right);
                } else if (item.equals("*")) {               // 乘法
                    right = data_stack.pop();
                    left = data_stack.pop();
                    data_stack.push(left * right);
                } else if (item.equals("/")) {               // 除法
                    right = data_stack.pop();
                    left = data_stack.pop();
                    data_stack.push(left / right);
                } else if (item.equals("^")) {               // 幂运算
                    right = data_stack.pop();
                    left = data_stack.pop();
                    data_stack.push(Math.pow(left, right));
                } else if (item.equals("cos")) {             // cos运算
                    left = data_stack.pop();
                    data_stack.push(Math.cos(left));
                } else if (item.equals("sin")) {             // sin运算
                    left = data_stack.pop();
                    data_stack.push(Math.sin(left));
                } else if (item.equals("tan")) {             // tan运算
                    left = data_stack.pop();
                    data_stack.push(Math.tan(left));
                } else if (item.equals("log")) {             // log运算
                    left = data_stack.pop();
                    data_stack.push(Math.log10(left));
                } else if (item.equals("ln")) {              // ln运算
                    left = data_stack.pop();
                    data_stack.push(Math.log1p(left));
                }
            }
        }

        if (data_stack.size() != 1)
            throw new Exception("表达式的操作数和操作符不匹配，请检查表达式是否正确\n" +
                    postfix_list.toString());

        return data_stack.pop();
    }

    /**
     * 将中缀表达式解析成后缀表达式
     * @param infix_list 要处理的中缀表达式
     * @return 返回后缀表达式
     */
    private static List<String> infix2postfix(List<String> infix_list) throws Exception {
        Stack<String> result_stack = new Stack<>();
        Stack<String> temp_stack = new Stack<>();
        String item;

        for (int i = 0; i<infix_list.size(); i++) {

            item = infix_list.get(i);
            if (isNumber(item)) { // 当前项是数字
                result_stack.push(item);
            } else if (item.equals("(")) { // 当前项是左括号
                temp_stack.push(item);
            } else if (item.equals(")")) { // 当前项是右括号
                while (!temp_stack.peek().equals("(")) {
                    result_stack.push(temp_stack.pop());
                }
                temp_stack.pop();
            } else { // 当前项是操作符
                while (temp_stack.size() != 0 && (OPERATOR.compare(temp_stack.peek(), item) >= 0)) {
                    result_stack.push(temp_stack.pop());
                }
                temp_stack.push(item);
            }
        }

        while (temp_stack.size() != 0) {
            result_stack.push(temp_stack.pop());
        }

        return result_stack.stream().collect(Collectors.toList());
    }

    /**
     * 完整一个中缀表达式数组，例如"2(2+3)"，在'2'和'('之间补充一个'*'操作符，使表达式完整
     * @param infix_list
     * @return
     */
    private static List<String> addOperator(List<String> infix_list) {
        for (int i = 0; i<infix_list.size()-1; i++) {
            // todo 在这里加一些判断，检查列表里是否有无法处理的字符格式

            if (isNumber(infix_list.get(i)) && infix_list.get(i+1).equals("(")) {
                infix_list.add(i+1, "*");
            }
        }
        return infix_list;
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
        String transfer; // 中转

        for (int i = 0; i<expressionStr.length(); i++) {

            transfer = String.valueOf(expressionStr.charAt(i));

            if (!isLetter(transfer) && !isNumber(transfer)) {
                if (func_temp_ls.length() != 0)
                    result_list.add(func_temp_ls.toString());
                if (number_temp_ls.length() != 0)
                    result_list.add(number_temp_ls.toString());

                func_temp_ls.setLength(0);
                number_temp_ls.setLength(0);
            }

            if (isNumber(transfer) ||
                    ((i == 0 || String.valueOf(expressionStr.charAt(i-1)).equals("("))) &&
                            (transfer.equals("-") ||transfer.equals("+"))) {

                number_temp_ls.append(transfer);
            } else if (isLetter(transfer)) {
                func_temp_ls.append(transfer);
            } else {
                result_list.add(transfer);
            }
        }

        if (func_temp_ls.length() != 0)
            result_list.add(func_temp_ls.toString());
        if (number_temp_ls.length() != 0)
            result_list.add(number_temp_ls.toString());
        return result_list;
    }

    /**
     * 判断一个字符串是否可以被转换成数字
     * @param str 要匹配的字符串
     * @return 满足条件: 以数字或者加减号开头 中间可以有小数点  假如中间有小数点，小数点后面必须是数字并且必须以数字结尾
     */
    private static boolean isNumber(String str) {
        return str.matches("^[-+]{0,1}[0-9]+$|^[-+]{0,1}[0-9]+[.]+[0-9]+$");
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
//        System.out.println(isNumber("l"));

        String expression = "ln(log(14))/5";
        try {
            System.out.println(doExpression(expression));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 运算符相关的操作
     */
    private static class OPERATOR {

        private static Map<String, Integer> OPERATOR_PRIORITY;

        static {
            OPERATOR_PRIORITY = new HashMap<>();
            OPERATOR_PRIORITY.put("+", 2);
            OPERATOR_PRIORITY.put("-", 2);
            OPERATOR_PRIORITY.put("*", 3);
            OPERATOR_PRIORITY.put("/", 3);
            OPERATOR_PRIORITY.put("^", 4);
            OPERATOR_PRIORITY.put("cos", 3);
            OPERATOR_PRIORITY.put("sin", 3);
            OPERATOR_PRIORITY.put("tan", 3);
            OPERATOR_PRIORITY.put("log", 3);
            OPERATOR_PRIORITY.put("ln", 3);
        }

        /**
         * 判断操作符的优先级
         * @param left
         * @param right
         * @return 正数-左的优先级大于右，负数-右的优先级大于左， 0-左右具有相同的优先级
         * @throws Exception 操作符没有被记录
         */
        public static int compare(String left, String right) throws Exception {
            Integer l = OPERATOR_PRIORITY.getOrDefault(left, 0);
            Integer r = OPERATOR_PRIORITY.get(right);

            if (l == null || r == null)
                throw new Exception("["+left+", "+right+"] 操作符不能被处理: '" +
                        (l == null ? left : right) + "'");

            return l - r;
        }
    }
}
