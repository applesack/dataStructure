package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月16日 23:34
 */
public class P47 {

    @Test
    public void testFunc() {
        int[] nums = {1, 1, 2};
        for (List<Integer> list : permuteUnique(nums)) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, int count,
                     ArrayList<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (count == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i<nums.length; i++) {
            if (used[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;  path.add(nums[i]);
            dfs(nums, count + 1, path, res, used);
            used[i] = false; path.remove(path.size() - 1);
        }
    }

}
