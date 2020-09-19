package leetcodes.nums.p401_600;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月11日 20:02
 */
public class P443 {

    @Test
    public void testFunc() {
        String in = "baaaaaaaaab";
        System.out.println(compress(in.toCharArray()));
    }

    public int compress(char[] chars) {
        int count = 0;
        if (chars == null || chars.length == 0)
            return count;
        count += 1;
        if (chars.length == 1)
            return count;

        int curCharCount = 1;
        int[] keys = new int[] {1, 10, 100, 1000, 10000, 100000};
        int[] values = new int[] {1, 2, 3, 4, 5, 6};

        for (int i = 1; i<chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (curCharCount > 9)
                    count += getMatchValue(curCharCount, keys, values);
                else
                    count += 1;
                curCharCount = 1;
            } else {
                curCharCount += 1;
            }
        }

        if (curCharCount >= 1)
            count += getMatchValue(curCharCount, keys, values);
        return count;
    }

    private int getMatchValue(int key, int[] keys, int[] values) {
        for (int i = keys.length - 1; i>=0; i--) {
            if (key >= keys[i])
                return values[i];
        }
        return 1;
    }

    @Test
    public void testMatch() {
        int[] keys = new int[] {1, 10, 100, 1000, 10000, 100000};
        int[] values = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println(getMatchValue(1, keys, values));
    }
}
