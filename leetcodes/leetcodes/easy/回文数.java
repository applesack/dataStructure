package leetcodes.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月05日 21:46
 */
public class 回文数 {

    public static void main(String[] args) {

        System.out.println(test(121));
        System.out.println(test(-121));
        System.out.println(test(10));
        System.out.println(test(0));
    }

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
}
