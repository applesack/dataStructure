package leetcodes.nums;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月23日 19:15
 */
public class P1309 {

    @Test
    public void testFunc() {
        String in =
//                "10#11#12"
                "1326#"
//                "25#"
//                "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
                ;
        System.out.println(freqAlphabets(in));
    }

    public String freqAlphabets(String s) {
        int[] tmp = new int[2];
        StringBuilder res = new StringBuilder();
        int pos = s.length() - 1;
        while (pos >= 0) {
            char c = s.charAt(pos);
            if (c == '#') {
                int count = 0;
                while (pos > 0 && count < 2 && s.charAt(pos - 1) != '#') {
                    tmp[count] = s.charAt(pos - 1) - '0';
                    count += 1;
                    pos--;
                }
                res.insert(0, getChar(tmp, count));
            } else {
                res.insert(0, getChar(c));
            }
            pos--;
        }


        return res.toString();
    }

    private char getChar(int[] nums, int count) {
        if (count == 1) {
            return (char) ('a' + nums[1] - 1);
        } else {
            int num = nums[1] * 10 + nums[0];
            return (char) ('a' + num - 1);
        }
    }

    private char getChar(char c) {
        return (char) ('a' + (c - '0') - 1);
    }

    @Test
    public void testGetCharFunc() {
//        System.out.println(getChar(new int[] {2, 6}, 2));
        System.out.println(getChar('9'));
    }

    private String freqAlphabets0(String s) {
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i<26; i++)
            map.put(String.valueOf(i + 1), (char) ('a' + i));

        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray())
            stack.push(c);
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '#') {
                sb.setLength(0);
                int count = 1;
                while (!stack.isEmpty() && count <= 2 && stack.peek() != '#') {
                    count += 1;
                    sb.insert(0, stack.pop());
                }
                res.insert(0, map.get(sb.toString()));
            } else {
                res.insert(0, map.get(String.valueOf(c)));
            }
        }

        return res.toString();
    }
}
