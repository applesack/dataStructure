package leetcodes.demo.数组类算法.数组类型转换;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月09日 14:45
 */
public class Test {

    @org.junit.Test
    public void testFunc() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        Integer[] integers_1 = pq.toArray(Integer[]::new);
        Integer[] integers_2 = pq.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integers_2));
    }

    abstract class Animal {
        abstract String getName();
    }

}
