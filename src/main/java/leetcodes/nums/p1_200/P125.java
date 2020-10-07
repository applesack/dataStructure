package leetcodes.nums.p1_200;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 22:13
 */
public class P125 {

    @Test
    public void testFunc() {
        String input =
//                "A man, a plan, a canal: Panama";
                "0P";
        System.out.println(isPalindrome(input));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;

        StringBuffer sb = new StringBuffer();
        char tmpChar;
        for (int i = 0; i<s.length(); i++) {
            tmpChar = s.charAt(i);
            if (Character.isLetter(tmpChar)) {
                sb.append(Character.toLowerCase(tmpChar));
            } else if (Character.isDigit(tmpChar)) {
                sb.append(tmpChar);
            }
        }

        if (sb.length() <= 1)
            return true;

        int half = sb.length() / 2;
        int len = sb.length() - 1;
        char left, right;
        for (int i = 0; i<=half; i++) {
            left = sb.charAt(i);
            right = sb.charAt(len - i);
            if (left != right)
                return false;
        }

        return true;
    }

}
