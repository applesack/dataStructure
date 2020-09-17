package test.version_feature.java11;

import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 14:29
 */
public class 集合加强 {

    public static void main(String[] args) {
        // 不可变集合
        var list = List.of("Java", "Python", "C");
        var copy = List.copyOf(list);

//        list.add("C#");


        System.out.println(list == copy);
    }

}
