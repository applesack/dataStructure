package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月26日 19:56
 */
public class P349 {

    @Test
    public void testFunc() {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        System.out.println(Arrays.toString(intersection(a, b)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1)
                .boxed().collect(Collectors.toSet());
        Set<Integer> res = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n))
                res.add(n);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
