package test.stream.lambda.demo03;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月29日 18:55
 */
public class StreamTest {

    public static void main(String[] args) {
        int[][] lines = {
                {1, 2, 3, 6, 2},
                {3, 4, 7}
        };

//        int[] line = {1, 2, 3, 4, 4};

//        Arrays.stream(line, 0, line.length)
//                .forEach(System.out::println);

        Arrays.stream(lines).forEach(line -> {
            Arrays.stream(line).forEach(n -> System.out.format("%d ", n));
        });
    }

}
