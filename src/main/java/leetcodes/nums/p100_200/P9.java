package leetcodes.nums.p100_200;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 9:53
 */
public class P9 {

    @Test
    public void testFunc() {
        int input = 12321;
        System.out.println(isPalindrome(input));
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x / 10 == 0)
            return true;

        StringBuffer sb = new StringBuffer();
        sb.append(x);

        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i<sb.length(); i++) {
            deque.add(sb.charAt(i));
        }

        char left, right;
        while (deque.size() >= 2) {
            left  = deque.pollFirst();
            right = deque.pollLast();

            if (left != right)
                return false;
        }

        return true;
    }
}
