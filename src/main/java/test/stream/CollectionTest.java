package test.stream;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月04日 21:31
 */

public class CollectionTest {

    public static void main(String[] args) {
        testToCollection();
    }

    private static void testToCollection() {
        String[] source = {
                "aaa", "bbb", "ccc"
        };

        // 转为数组
        String[] res_1 = Stream.of(source).toArray(String[]::new);
        // 转为列表
        List<String> res_2 = Stream.of(source).collect(Collectors.toList());
        // 转为Set
        Set<String> res_3 = Stream.of(source).collect(Collectors.toSet());
        // 连接所有结果
        String res_4 = Stream.of(source).collect(joining(", "));
        // 转换为Deque
        Deque<String> res_5 = Stream.of(source).collect(toCollection(LinkedList::new));
    }
}
