package leetcodes.nums.p100_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 11:05
 */
public class P14 {

    @Test
    public void testFunc() {
        String[] input = {"c", "c"};
        System.out.println(longestCommonPrefix(input));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        int commonPrefixIdx = 0;
        char curChar = ' ';
        StringBuffer sb = new StringBuffer();
        while (true) {
            if (strs[0] != null && strs[0].length() >= commonPrefixIdx + 1)
                curChar = strs[0].charAt(commonPrefixIdx);
            else
                break;

            for (String s : strs) {
                if (s == null || s.length() < commonPrefixIdx + 1)
                    return sb.toString();
                if (s.charAt(commonPrefixIdx) != curChar)
                    return sb.toString();
            }

            sb.append(curChar);
            commonPrefixIdx++;
        }

        return sb.toString();
    }
}
