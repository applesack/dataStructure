package leetcodes.zleetcodes.easy;

import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月09日 10:07
 */

@LeetCodes(
        id = 20,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/09"
)
public class 有效的括号 {

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

    @Test
    public void Run() {
        System.out.println(test(""));
        System.out.println(test("()"));
        System.out.println(test("()("));
        System.out.println(test("(]"));
        System.out.println(test("{[]}"));
        System.out.println(test("{[[]()]}"));
    }
}
