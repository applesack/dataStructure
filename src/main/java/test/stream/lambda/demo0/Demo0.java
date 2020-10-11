package test.stream.lambda.demo0;

import org.jsoup.select.Collector;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月11日 10:45
 */
public class Demo0 {

    @Test
    public void testFuncR1() {
        int[][] input = {
                {5, 3},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {4, 4}
        };
        System.out.println(R1(input));
    }

    @Test
    public void testFuncR2() {
        int[] in = {1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(R2(k, in));
    }

    @Test
    public void testFuncR3() {
        System.out.println(R3(2, 3));
    }

    public List<Integer> R1(int[][] table) {
        // 输入有误，返回空结果
        if (table.length <= 1)
            return null;
        int commit_count = table[0][0]; // 总共提交数
        int reward_count = table[0][1]; // 奖励排名前n的员工

        Set<Integer> empIdSet = Arrays.stream(table) // 此时stream的类型是int[]
                // 跳过第一个数据，因为第一个数据只提供信息，和实际数据无关
                .skip(1)
                // 按照员工的分数排序
                .sorted(Comparator.comparingInt(arr -> arr[1]))
                // 对于排序后的结果，只保留员工id
                .map(arr -> arr[0])
                // 收集成Set集合，过滤掉重复的员工id
                .collect(Collectors.toSet());

        return empIdSet.stream()
                // 将Set集合进行排序，使得分数高的员工在前面，分数低的在后面
                .sorted(Comparator.reverseOrder())
                // 只保留指定的结果
                .limit(reward_count)
                // 收集成List返回
                .collect(Collectors.toList());
    }

    public int R2(int k, int ... nums) {
        return k + IntStream.range(0, k)
                .reduce(Math::max)
                .getAsInt();
    }

    public int R3(int a, int b) {
        int area = a * b;
        // 所给的矩形面积不能被二整除，则无法被分完，返回0
        if (area % 2 != 0)
            return 0;

        // 最基础的情况：当面积为2，只有1中分法，往后遵循斐波那契数列
        int base = 1;
        int next = 1;
        int then = 2, tmp;
        while (then <= area) {
            then += 2;

            // 向前进位
            tmp = next;
            next = base + next;
            base = tmp;
        }
        return base;
    }

}
