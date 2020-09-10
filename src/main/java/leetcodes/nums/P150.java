package leetcodes.nums;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月10日 17:19
 */
public class P150 {

    @Test
    public void testFunc() {
        String[] items = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(items));
    }

    public int evalRPN(String[] tokens) {
        // 操作符
        Set<String> operation = new HashSet<>();
        operation.add("+");
        operation.add("-");
        operation.add("*");
        operation.add("/");

        Stack<Integer> res_stack = new Stack<>();
        Integer num1, num2;
        for (String item : tokens) {
            if (operation.contains(item)) {

                num2 = res_stack.pop();
                num1 = res_stack.pop();

                if (item.equals("+")) {
                    res_stack.push(num1 + num2);
                } else if (item.equals("-")) {
                    res_stack.push(num1 - num2);
                } else if (item.equals("*")) {
                    res_stack.push(num1 * num2);
                } else {
                    res_stack.push(num1 / num2);
                }

            } else {
                res_stack.push(Integer.parseInt(item));
            }
        }

        return res_stack.pop();
    }

}
