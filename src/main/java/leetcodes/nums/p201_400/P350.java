package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月27日 14:58
 */
public class P350 {

    @Test
    public void testFunc() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] numa, numb;
        if (nums1.length == nums2.length) {
            numa = nums1;
            numb = nums2;
        } else {
            numa = nums1.length > nums2.length ? nums1 : nums2; // longer
            numb = nums1.length < nums2.length ? nums1 : nums2; // shorter
        }

        boolean[] tmp = new boolean[numb.length];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int cur : numa) {
            for (int j = 0; j < numb.length; j++) {
                if (!tmp[j] && numb[j] == cur) {
                    tmp[j] = true;
                    ans.add(numb[j]);
                    break;
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
