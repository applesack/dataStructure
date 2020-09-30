package test.stream.lambda.demo03;

import demo.util.ProxyUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年09月30日 12:46
 */
public class 测试各种方式的遍历效率 {

    public static void main(String[] args) {
        测试各种方式的遍历效率 instance = new ProxyUtil<>(测试各种方式的遍历效率.class).getInstance();

        Random ran = new Random();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i<100000000; i++) {
            integerList.add(ran.nextInt(Integer.MAX_VALUE));
        }

        // 1. Stream
        instance.testStream(integerList);
        // 2. parallelStream
        instance.testParallelStream(integerList);
        // 3. 普通for
        instance.testForLoop(integerList);
        // 4. 增强for
        instance.testPowerForLoop(integerList);
        // 5. 迭代器
        instance.testIterator(integerList);
    }

    // 当数据较少，使用stream速度较快
    public void testStream(List<Integer> list) {
        Integer res = list.stream().max(Integer::compareTo).get();
        System.out.println(res);
    }

    // 将数据量大。并行流更快
    public void testParallelStream(List<Integer> list) {
        Integer res = list.stream().parallel().max(Integer::compareTo).get();
        System.out.println(res);
    }

    public void testForLoop(List<Integer> list) {
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i<list.size(); i++) {
            Integer cur = list.get(i);
            if (cur > max)
                max = cur;
        }
        System.out.println(max);
    }

    public void testPowerForLoop(List<Integer> list) {
        Integer max = Integer.MIN_VALUE;
        for (Integer cur : list) {
            if (cur > max)
                max = cur;
        }
        System.out.println(max);
    }

    public void testIterator(List<Integer> list) {
        Integer max = Integer.MIN_VALUE;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer cur = iterator.next();
            if (cur > max)
                max = cur;
        }
        System.out.println(max);
    }
}
