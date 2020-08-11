package zleetcodes.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年07月17日 21:51
 */
public class 好数对的数目 {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return -1;
    }

    @Test
    public void Run() {
        int[] input = new int[]{1,2,3,1,1,3};
        numIdenticalPairs(input);
    }
}
