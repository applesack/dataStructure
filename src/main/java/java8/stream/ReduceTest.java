package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月04日 23:00
 */
public class ReduceTest {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        // 用约简计算所有元素的和，两两相加
        nums.stream().reduce((n1, n2) -> n1 + n2).ifPresent(System.out::println);
        int sum = nums.stream().reduce(Integer::sum).orElse(0);
    }

}
