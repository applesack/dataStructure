package leetcodes.easy;

import leetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年07月03日 0:20
 */

@LeetCodes(
        id = 1047,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/07/03"
)
public class 删除字符串中的所有相邻重复项 {

    public String removeDuplicates(String S) {

        if (S.length() < 2) return S;

        Stack<Character> stack = new Stack<>();
        int len = S.length();
        char theChar;
        stack.push(S.charAt(0));
        for (int index = 1; index<len; index++) {
            theChar = S.charAt(index);
            if (!stack.isEmpty() && theChar == stack.peek())
                stack.pop();
            else
                stack.push(theChar);
        }

        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) buffer.append(stack.pop());

        return buffer.reverse().toString();
    }

    public String removeDuplicates2(String S) {
        int len = S.length();
        char[] source = S.toCharArray();  // 源数组
        char[] res    = new char[len];    // 目的数组
        // count:模拟栈操作，表示栈顶的位置； count:有效字符的个数
        int index     = 1, count = 1;

        res[0] = source[0];
        for (; index<len; index++) {
            // 当前字符于栈顶的字符相同，栈顶下降一格
            if (count >= 1 && source[index] == res[count-1]) {
                count--;
                continue;
            }
            // 栈push进来一个元素
            res[count++] = source[index];
        }

        return new String(res).substring(0, count);
    }

    @Test
    public void Run() {
       String str = "aabaa";
//        System.out.println(removeDuplicates(str));
        System.out.println(removeDuplicates2(str));
    }
}
