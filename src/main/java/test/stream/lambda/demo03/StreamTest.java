package test.stream.lambda.demo03;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年09月29日 18:55
 */
public class StreamTest {

    public static void main(String[] args) {
        int[][] lines = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
        };

//        int[] line = {1, 2, 3, 4, 4};

//        Arrays.stream(line, 0, line.length)
//                .forEach(System.out::println);

//        Arrays.stream(lines)
//                .forEach(line -> {
//            Arrays.stream(line).forEach(n -> System.out.format("%d ", n));
//        });
//
//        Arrays.stream(lines[0], 0, lines[0].length)
//                .forEach(System.out::println);

//        IntStream.range(0, 10)
//                .forEach(System.out::println);

        // 将二维数组的每个元素(每个元素是一维数组)，汇聚成一个流，过滤掉单数，其余打印
        int[] nArr = Arrays.stream(lines)
                .flatMapToInt(Arrays::stream)
                .filter(number -> number % 2 == 0)
                .toArray();

        System.out.println(Arrays.toString(nArr));

    }

}
