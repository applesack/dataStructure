package leetcodes.nums.p201_400;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author flutterdash@qq.com
 * @date 2020/09/06 13:58
 */
public class P387 {
   
    public static void main(String[] args) {
        String input = 
                // "leetcode";
                // "loveleetcode";
                "cc";
        System.out.println(firstUniqChar(input));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) 
            return -1;
        if (s.length() == 1)
            return 0; 
        
        int[] data = new int[26];
        char tmpChar;
        for (int i = 0; i<s.length(); i++) {
            tmpChar = s.charAt(i);
            data[tmpChar - 'a'] += 1;
        }

        for (int i = 0; i<s.length(); i++) {
            if (data[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }

}
