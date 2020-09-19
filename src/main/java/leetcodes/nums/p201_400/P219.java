package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月14日 11:17
 */
public class P219 {

    @Test
    public void testFunc() {
        int[] in = {1, 2, 3, 1};
        System.out.println(containsNearbyDuplicate(in, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                list.add(i);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) - list.get(i - 1) <= k)
                        return true;
                }
            }
        }

        return false;
    }

}
