package test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月07日 23:36
 */
public class StaticMethodTest {

    private static void Func() {
        System.out.println("静态方法");

    }

    private void notStaticFunc() {
        System.out.println("非静态方法");
    }

    public static void main(String[] args) {
        Func();
        StaticMethodTest.Func();
        new StaticMethodTest().notStaticFunc();
    }
}
