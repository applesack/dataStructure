package leetcodes.nums.p201_400;

import java.util.Arrays;

/**
 * @author  flutterdash@qq.com
 * @date    2020/09/06 14:28
 */
public class P389 {
   
    public static void main(String[] args) {
        String source = "abcd";
        String target = "abcde";
        System.out.println(findTheDifference(source, target));
    }

    private static char findTheDifference(String s, String t) {
        if (s.length() == 0)
            return t.charAt(0);

        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        
        Arrays.sort(source);
        Arrays.sort(target);

        for (int i = 0; i<source.length; i++) {
            if (source[i] != target[i]) {
                return target[i];
            }
        }

        return target[target.length - 1];
    }

}
