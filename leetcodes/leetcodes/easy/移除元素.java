package leetcodes.easy;

import leetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月05日 20:29
 */

@LeetCodes(
        id = 27,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/05"
)
public class 移除元素 {

    @Test
    public void Run(String[] args) {

        test(new int[]{3,2,2,3}, 3);
        test(new int[]{0,1,2,2,3,0,4}, 2);
    }

    public static int test(int[] arr, int val) {
        int len = 0;

        for (int i = 0; i<arr.length; i++) {
            if (arr[i]!=val) {
                arr[len++] = arr[i];
            }
        }

        // 输出
        System.out.print("len: "+len+" [");
        for (int i = 0; i<len; i++)
            System.out.print(arr[i]+", ");
        System.out.print("]\n");

        return len;
    }
}
