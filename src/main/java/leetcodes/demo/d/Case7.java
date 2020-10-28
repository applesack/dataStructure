package leetcodes.demo.d;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月27日 10:43
 */
public class Case7 {

    @Test
    public void testFunc() {
        System.out.println(isInOrder("abca"));
        System.out.println(isInOrder("abc"));
    }

    public static boolean isInOrder(String check) {
        int pos = 0;
        while (pos < check.length() - 1) {
            String letter1 = check.substring(pos, pos + 1);
            String letter2 = check.substring(pos + 1, pos + 2);
            if (letter1.compareTo(letter2) > 0)
                break;
            if (pos == check.length() - 2) {
                return true;
            }
            pos++;
        }
        return false;
    }

}
