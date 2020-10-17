package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月16日 22:15
 */
public class P18 {

    @Test
    public void testFunc() {
        int[] input = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = fourSum(input, 0);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        nSumCore(nums, 0, 4, target, map, new ArrayList<>(), res);
        return res;
    }

    private void nSumCore(int[] nums, int cursor, int n, int target,
                          Map<Integer, Integer> map, ArrayList<Integer> path, List<List<Integer>> res) {
        if (cursor == n - 1) {
            Integer index = map.get(target);
            if (index == null || index < cursor)
                return;
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = cursor; i<(nums.length - n - 1); i++) {
            path.add(nums[i]);
            nSumCore(nums, cursor + 1, n - 1, (target - nums[i]), map, path, res);
            path.remove(path.size() - 1);
        }
    }

}
