package offer.part2;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月01日 19:45
 */
public class P5 {

    /**
     * 将字符串中的空格替换成%20
     * @param str
     * @return
     */
    private String replaceBlank(String str) {
        if (str == null || str.equals(""))
            return "";

        StringBuffer sb = new StringBuffer();

        char c;
        for (int i = 0; i<str.length(); i++) {
            c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    @Test
    public void Test() {
        String input = "abc def";

        System.out.println(replaceBlank(input));
    }
}
