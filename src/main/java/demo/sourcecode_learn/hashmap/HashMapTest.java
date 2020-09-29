package demo.sourcecode_learn.hashmap;

import java.util.HashMap;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月29日 9:45
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("1", 2);
        System.out.println(map);
    }

}
