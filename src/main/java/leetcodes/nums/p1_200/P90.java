package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月17日 11:00
 */
public class P90 {

    @Test
    public void testFunc() {
        int[] nums = {1, 2, 3};
        for (List<Integer> list : subsetsWithDup(nums))
            System.out.println(list);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int count, boolean[] used,
                     ArrayList<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        int size = path.size();
        for (int i = count; i<nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            if (!path.isEmpty() && nums[i] < path.get(size - 1))
                continue;

            path.add(nums[i]);
            used[i] = true;

            dfs(nums, count + 1, used, path, res);

            used[i] = false;
            path.remove(size);

        }
    }

}
