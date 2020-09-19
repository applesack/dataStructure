package leetcodes.nums.p100_200;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月01日 10:29
 */
public class P65 {

    @Test
    public void testFunc() {
        String input = "0.e9";
        System.out.println(isNumber(input));
    }

    /**
     * 判断一个字符串是否可以被解析成字符串
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;

        char[] chars = s.toCharArray();
        int len = chars.length;
        int pos = 0;
        while (pos < len && (chars[pos] == '+' || chars[pos] == '-')) {
            pos++;
        }

        // 符号位的长度, 假如符号位超过1个，或者整个字符串只包含符号，则不能被解析成数字
        int symbolSize = pos;
        if (symbolSize > 1 || symbolSize == len)
            return false;

        // 找到小数点的位置
        int pointIdx = s.indexOf('.');
        if (pointIdx == -1) {
            return doInteger(chars, symbolSize, len - 1);
        } else {
            // 假如只有一个小数点，则该字符串也不能解析
            if (chars.length == 1)
                return false;

            return doInteger(chars, symbolSize, pointIdx - 1) &&
                doInteger(chars, pointIdx + 1, len - 1);
        }
    }

    /**
     * 判断一个字符序列是否符合数字的规范
     * 只有3种情形
     * 123
     * 123e123
     * 123e-123
     *
     * @param chars
     * @param l
     * @param r
     * @return
     */
    private boolean doInteger(char[] chars, int l, int r) {
        int pos = l;
        // 找到第一个不是数字的位置
        for (pos = l; pos<=r; pos++) {
            if (!Character.isDigit(chars[pos]))
                break;
        }

        // 所有内容都是数字
        if (pos > r)
            return true;
        int numberLen = pos - l + 1;
        if (numberLen < 1)
            return false;

        // 被中断的位置不是e，则不能被解析成数字
        if (chars[pos] != 'e')
            return false;

        int eIdx = pos;
        // 检查e后面是否有符号位
        for (pos++ ; pos<=r; pos++) {
            if (chars[pos] != '+' && chars[pos] != '-')
                break;
        }

        // e后面都是符号，或者符号位超过1个，则不能被解析成数字
        if (pos > r || pos - (eIdx + 1) > 1)
            return false;
//        pos++;

        // 余下部分必须全是数字
        for (;pos<=r; pos++) {
            if (!Character.isDigit(chars[pos]))
                return false;
        }
        return true;
    }

    private boolean doDecimal(char[] chars, int l, int r) {


        return false;
    }
}
