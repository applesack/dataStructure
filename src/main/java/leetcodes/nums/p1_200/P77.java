package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月17日 8:34
 */
public class P77 {

    @Test
    public void testFunc() {
        List<List<Integer>> res = combine(4, 2);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i<n; i++)
            nums[i] = i + 1;
        dfs(nums, 0, k, new ArrayList<>(), res, new boolean[n]);
        return res;
    }

    private void dfs(int[] nums, int count, int tCount,
                     ArrayList<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (count == tCount) {
            res.add(new ArrayList<>(path));
            return;
        }

        int size = path.size();
        for (int i = count; i<nums.length; i++) {
            if (used[i])
                continue;
            if (size > 0 && nums[i] < path.get(size - 1))
                continue;

            used[i] = true;
            path.add(nums[i]);

            dfs(nums, count + 1, tCount, path, res, used);

            path.remove(size);
            used[i] = false;
        }
    }

}
