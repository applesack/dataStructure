package leetcodes.easy;

import leetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月09日 11:25
 */

@LeetCodes(
        id = 26,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/09"
)
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(test(new int[]{1,2,2,3,3,4,4,4,4,5})));
    }

    public static int[] test(int[] sortList) {
        if (sortList.length <= 1)
            return sortList;

        int len = 0;
        for (int i = 1; i<sortList.length; i++) {
            if (sortList[i] != sortList[len])
                sortList[++len] = sortList[i];
        }

        return Arrays.copyOf(sortList, len+1);
    }

    @Test
    public void Run() {
        System.out.println("111");
    }
}
