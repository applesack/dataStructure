package test.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月04日 21:54
 */
public class ToMap {

    private static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"), new Person(1002, "Paul"),
                new Person(1003, "chaos"), new Person(1001, "od"));
    }

    public static void main(String[] args) {
        Map<Integer, String> idToName = people().collect(
                Collectors.toMap(Person::getId, Person::getName));
        System.out.println("case_1: " + idToName);

        /**
         * toMap()方法 toMap(KeyMapper, valueMapper, mergeFunction, mapSupplier)
         * KeyMapper 返回键的方法
         * valueMapper 返回值的方法
         * mergeFunction 当新传进来的数据项所生成的键与已有的键冲突，用这个方法消除冲突， (旧值，新值) -> {return 值}
         * mapSupplier 使用指定的构造器创建 HashMap, TreeMap等
         */

        Map<Integer, Person> idToPerson = people().collect(
                Collectors.toMap(Person::getId, Function.identity(),
                // 假如遇到重复的键(id值相同，则采用新值)， 使用HashMap创建Map
                (existingValue, newValue) -> newValue, HashMap::new));
    }
}
