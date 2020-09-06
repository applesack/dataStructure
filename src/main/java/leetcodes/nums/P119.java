package leetcodes.nums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月03日 19:41
 */
public class P119 {

    @Test
    public void testFunc() {
        System.out.println(getRow(2));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        // 第一层
        ArrayList<Integer> level_1 = new ArrayList<>();
        level_1.add(1);
        res.add(level_1);

        if (rowIndex == 0)
            return res.get(0);

        // 第二层
        ArrayList<Integer> level_2 = new ArrayList<>();
        level_2.add(1);
        level_2.add(1);
        res.add(level_2);
        if (rowIndex == 1)
            return res.get(1);

        ArrayList<Integer> this_level;
        List<Integer> upper_level;
        for (int i = 2; i<=rowIndex; i++) {

            upper_level = res.get(i - 1);
            this_level = new ArrayList<>();
            this_level.add(1);
            for (int j = 1; j<i; j++) {
                this_level.add(upper_level.get(j) + upper_level.get(j - 1));
            }
            this_level.add(1);
            res.add(this_level);
        }

        return res.get(rowIndex);
    }

}
