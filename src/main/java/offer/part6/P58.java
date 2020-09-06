package offer.part6;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月21日 11:14
 */
public class P58 {

    @Test
    public void testFunc() {
        String input = "I am a Student.";
        System.out.println(reverse_myImpl(input));
    }

    public String reverse_myImpl(String str) {
        if (str == null || str.length() == 0)
            return "";

        String[] words = str.split(" ");
        StringBuffer reverseStr = new StringBuffer();

        for (String word : words) {
            reverseStr.insert(0, word);
            reverseStr.insert(0, ' ');
        }

        // 删除前面的空格
        reverseStr.delete(0, 1);
        return reverseStr.toString();
    }
}
