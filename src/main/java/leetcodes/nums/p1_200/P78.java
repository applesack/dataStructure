package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月16日 17:22
 */
public class P78 {

    @Test
    public void testFunc() {
        int[] in = {1, 2, 3, 4};
        System.out.println(subsets(in));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
