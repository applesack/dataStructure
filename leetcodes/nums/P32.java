package nums;

import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月25日 11:14
 */
public class P32 {

    @Test
    public void testFunc() {
        String input_1 = "()(()())";
        String input_2 = ")(((((()())()()))()(()))(";
        System.out.println(longestValidParentheses(input_2));
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
