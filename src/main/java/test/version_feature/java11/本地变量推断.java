package test.version_feature.java11;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 14:20
 */
public class 本地变量推断 {

    public static void main(String[] args) {
        String[] strings = {"", "", ""};
        Object var;
        var str = strings[0];
        System.out.println(str.equals(""));
    }

}
