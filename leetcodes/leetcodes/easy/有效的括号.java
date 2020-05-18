package leetcodes.easy;

import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月09日 10:07
 */
public class 有效的括号 {

    public static void main(String[] args) {

        System.out.println(test(""));
        System.out.println(test("()"));
        System.out.println(test("()("));
        System.out.println(test("(]"));
        System.out.println(test("{[]}"));
        System.out.println(test("{[[]()]}"));
    }

    public static boolean test(String strs) {

        String left_brackets =   "{[(";
        String right_brackets =  "}])";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<strs.length(); i++) {
            if (left_brackets.indexOf(strs.charAt(i)) != -1)
                stack.add(strs.charAt(i));
            else {
                if (stack.isEmpty())
                    return false;
                if (left_brackets.indexOf(stack.peek()) == right_brackets.indexOf(strs.charAt(i)))
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
