package leetcodes.nums.p1_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月26日 15:31
 */
public class P39 {

    @Test
    public void testFunc() {
        int[] input = {2,3,6,7};
        List<List<Integer>> res = combinationSum(input, 7);
        for (List<Integer> item : res) {
            System.out.println(item);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (candidates == null || candidates.length == 0)
            return res;

        Arrays.sort(candidates);
        Deque<Integer> deque = new ArrayDeque<>();
        getFixNumber(res, deque, 0, target, candidates);
        return res;
    }

    public void getFixNumber(List<List<Integer>> res, Deque<Integer> curList, int begin,
                             int target, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(curList));
            return;
        }

        int tmpRes;
        for (int i = begin; i<candidates.length; i++) {
            tmpRes = target - candidates[i];
            if (tmpRes < 0)
                break;
            curList.addLast(candidates[i]);
            getFixNumber(res,curList, i, tmpRes, candidates);
            curList.removeLast();
        }
    }
}
