package leetcodes.nums;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P46 {

    @Test
    public void testFunc() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        permuteCore(res, new LinkedList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void permuteCore(List<List<Integer>> res, LinkedList<Integer> track,
                             int[] options, boolean[] path) {

        if (track.size() == options.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i<options.length; i++) {
            if (!path[i]) {
                path[i] = true;

                track.add(options[i]);
                permuteCore(res, track, options, path);
                track.removeLast();

                path[i] = false;
            }
        }

    }

}
