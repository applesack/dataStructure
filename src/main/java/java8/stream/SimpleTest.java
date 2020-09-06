package java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月04日 17:43
 */
public class SimpleTest {

    public static void main(String[] args) throws IOException {
        of("abC", "dEDf", "hIIj");
        generate();
        testLines(Paths.get("java8", "stream", "file.txt"));
    }

    private static void of(String ... strings) {

       Stream.of(strings)
                .map(String::toLowerCase)
                .forEach(System.out::println);
    }

    private static void generate() {
        Stream.generate(Math::random)
                .limit(25)
                .forEach(System.out::println);
    }

    // 测试移除注释行
    private static void testLines(Path path) throws IOException {
        Files.lines(path, StandardCharsets.UTF_8)
                .map(String::trim)
                .filter(line ->
                        !line.startsWith("#") && !line.startsWith("//")
                ).forEach(System.out::println);
    }

    private static void option() {
        // 产生 1 ~ 2 之间的随机数
        // 过滤其中值为2的数
        int res = Stream.generate(Math::random)
                .limit(25)
                .map(x -> (int) (x * (2 - 1) + 1))
                .filter(x -> x%2 == 0)
                .max(Integer::compareTo)
                .orElse(0);
    }

}
