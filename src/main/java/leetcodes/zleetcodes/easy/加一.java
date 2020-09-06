package leetcodes.zleetcodes.easy;

import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月17日 20:14
 */

@LeetCodes(
        id = 66,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/17"
)
public class 加一 {

    private static int[] test(int[] digits) {
        boolean isCarry = false;
        int i = digits.length-1;
        if (digits[i] == 9) {
            digits[i] = 0;
            i -= 1;
            isCarry = true;

            while (isCarry && i>=0) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    isCarry = false;
                }
                i--;
            }

            if (isCarry) {
                int[] newArr = new int[digits.length+1];
                newArr[0] = 1;
                for (i = 1; i<newArr.length; i++)
                    newArr[i] = digits[i-1];
                return newArr;
            }

            return digits;
        }
        digits[digits.length-1] += 1;
        return digits;
    }

    @Test
    public void Run() {
        System.out.println(Arrays.toString(test(new int[]{9,8,9,9,9,9,9})));
    }
}
