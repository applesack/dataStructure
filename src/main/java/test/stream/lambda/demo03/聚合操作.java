package test.stream.lambda.demo03;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <p>Stream常见API介绍
 *      1. 聚合操作
 *
 *      2. Stream的处理流程
 *          2.1 获取数据源
 *          2.2 进行数据转换
 *          2.3 获取结果
 *
 *      3. 获取Stream对象
 *          3.1 从集合中获取
 *              Collection.stream()
 *              Collection.parallelStream() // 并行流
 *              Arrays.stream(T t)
 *          3.2 BufferReader.line() -> stream()
 *          3.3 静态工厂
 *              java.util.stream.IntStream.range
 *              java.nio.file.Files.walk()
 *          3.4 自定构建
 *              java.util.Spliterator
 *          3.5 更多方式
 *              Random.ints()
 *              Pattern.splitAsStream()...
 *      4. 中间操作API{intermediate}
 *          操作结果是一个Stream对象，所以中间操作可以有一个或者多个中间操作，需要注意的是，中间操作只记录操作方式，
 *              不做具体执行，直到结束操作发生时，才做数据的最终执行。
 *              中间操作：就是业务逻辑处理。
 *          中间操作过程：
 *              无状态：数据处理时，不受前置中间操作的影响。map/filter/peek/parallel/sequential/unordered
 *              有状态：数据处理时，受到前置中间操作的影响。distinct/sorted/limit/skip
 *      5. 终结操作|结束操作{Terminal}
 *          需要注意：一个Stream对象，只能有一个Terminal操作，这个操作一旦发生，就会真实处理数据，生成对应的处理结果。
 *          终结操作：
 *              非短路操作：当前Stream对象必须处理完集合中的所有数据，才能得到处理结果。
 *                  forEach/forEachOrdered/toArray/reduce/collect/min/max/count/iterator
 *              短路操作：当前Stream对象在处理过程中，一旦满足某个条件，就可以得到结果
 *                  anyMatch/allMatch/noneMatch/findFirst/findAny等
 * </p>
 *
 * @author : flutterdash@qq.com
 * @since : 2020年09月30日 9:11
 */
public class 聚合操作 {

    public static void main(String[] args) {

        // 1. 批量数据 -> Stream对象
        Stream<String> stream = Stream.of("admin", "tom", "damu");

        // 数组
        String[] strArrays = new String[] {"xueqi", "biyao"};
        Stream<String> stream1 = Arrays.stream(strArrays);

        // 列表
        List<String> list = new ArrayList<>();
        list.add("少林");
        list.add("武当");
        list.add("青城");
        list.add("崆峒");
        list.add("峨眉");
        Stream<String> stream2 = list.stream();

        // 集合
        Set<String> set = new HashSet<>();
        set.add("少林罗汉拳");
        set.add("武当长拳");
        set.add("青城剑法");
        Stream<String> stream3 = set.stream();

        // Map
        Map<String, Integer> map = new HashMap<>();
        map.put("tom", 1000);
        map.put("jerry", 1200);
        map.put("shuke", 1000);
        Stream stream4 = map.entrySet().stream();

        // 2. Stream对象对于基本数据类型的基本功能封装
        // int / long / double
        IntStream.of(new int[] {10, 20, 30}).forEach(System.out::println);
//        IntStream.range(0, 20).forEach(System.out::println);
        IntStream.rangeClosed(0, 20).peek(System.out::println).forEach(x -> {});


    }

}
