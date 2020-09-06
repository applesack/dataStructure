package leetcodes.nums;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月26日 17:54
 */
public class P40 {

    @Test
    public void testFunc() {
        int[] input = {10, 1, 2, 7, 6, 1, 5};
        int[] input_2 = {2, 5, 2, 1, 2};
        List<List<Integer>> res = combinationSum2(input_2, 5);
        for (List<Integer> item : res) {
            System.out.println(item);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);


        getFixNumbers(res, target, new ArrayDeque<>(),
                candidates, new int[candidates.length]);

        return res;
    }

    public void getFixNumbers(List<List<Integer>> res, int target, Deque<Integer> curPath,
                              int[] candidates, int[] paths) {
        if (target == 0) {
            // 检查是否已经存在有相同的解
            ArrayList<Integer> answer = new ArrayList<>(curPath);
            answer.sort(Integer::compareTo);
            boolean isExist = true;
            boolean isSameAnswer;
            for (List<Integer> item : res) {
                if (item.get(0).equals(answer.get(0))) {
                    if (item.size() == answer.size()) {
                        isSameAnswer = true;
                        for (int i = 1; i<answer.size(); i++) {
                            if (!answer.get(i).equals(item.get(i))) {
                                isSameAnswer = false;
                                break;
                            }
                        }

                        if (isSameAnswer)
                            return;
                    }
                }
            }
            if (isExist)
                res.add(new ArrayList<>(curPath));
            return;
        }

        int tmpTarget;
        for (int i = 0; i<candidates.length; i++) {
            if (paths[i] != 0)
                continue;
            tmpTarget = target - candidates[i];
            if (tmpTarget < 0)
                break;
            paths[i] = 1;
            curPath.addLast(candidates[i]);
            getFixNumbers(res, tmpTarget, curPath, candidates, paths);
            curPath.removeLast();
            paths[i] = 0;
        }
    }
}
