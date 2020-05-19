package leetcodes.easy;

import leetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月05日 21:46
 */

@LeetCodes(
        id = 9,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/05"
)
public class 回文数 {

    public static boolean test(int num) {

        Deque<Character> deque = new LinkedList();
        String str = new String(String.valueOf(num));

        for (int i = 0; i<str.length(); i++)
            ((LinkedList) deque).add(str.charAt(i));

        while (deque.size() >= 2) {
            char left = deque.pollFirst();
            char right = deque.pollLast();

            if (left != right)
                return false;
        }

        return true;
    }

    @Test
    public void Run() {
        System.out.println(test(121));
        System.out.println(test(-121));
        System.out.println(test(10));
        System.out.println(test(0));
    }
}
