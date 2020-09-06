package leetcodes.nums;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 20:50
 */
public class P28 {

    @Test
    public void testFunc() {
        String haystack = "aaaaa";
        System.out.println(strStr(haystack, "bba"));
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() < needle.length())
            return -1;
        if (needle.equals(""))
            return 0;

        char[] hayArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        int pos = 0;
        for (int i = 0; i<hayArr.length; i++) {
            if (hayArr[i] == needleArr[0]) {
                pos = i;
            } else
                continue;

            if (hayArr.length - pos < needleArr.length)
                return -1;

            int j = 1;
            for (; j<needleArr.length; j++) {
                if (hayArr[i + j] != needleArr[j])
                    break;
            }

            if (j == needleArr.length)
                return i;
        }

        return -1;
    }
}
