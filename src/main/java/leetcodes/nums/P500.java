package leetcodes.nums;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月12日 12:01
 */
public class P500 {

    @Test
    public void testFunc() {
        String[] words = {"hello", "Alaska", "Peace", "Dad"};
        System.out.println(Arrays.toString(findWords(words)));
    }

    public String[] findWords(String[] words) {

        String line_1_str = "qwertyuiop";
        String line_2_str = "asdfghjkl";
        String line_3_str = "zxcvbnm";

        Set<Character> line_1 = new HashSet<>();
        Set<Character> line_2 = new HashSet<>();
        Set<Character> line_3 = new HashSet<>();

        for (int i = 0; i<line_1_str.length(); i++)
            line_1.add(line_1_str.charAt(i));
        for (int i = 0; i<line_2_str.length(); i++)
            line_2.add(line_2_str.charAt(i));
        for (int i = 0; i<line_3_str.length(); i++)
            line_3.add(line_3_str.charAt(i));

        Set[] lines = new Set[] {line_1, line_2, line_3};
        ArrayList<String> res = new ArrayList<>();

        char curChar;
        int theIdx = 0;
        boolean flag;
        for (String item : words) {
            curChar = Character.toLowerCase(item.charAt(0));
            for (int i = 0; i<lines.length; i++) {
                if (lines[i].contains(curChar)) {
                    theIdx = i;
                    break;
                }
            }

            flag = true;
            for (int i = 1; i<item.length(); i++) {
                if (!lines[theIdx].contains(Character.toLowerCase(item.charAt(i)))) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                res.add(item);
        }

        String[] rel_res = new String[res.size()];
        return res.toArray(rel_res);
    }

}
