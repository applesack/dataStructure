package test.stream.lambda.demo02;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月29日 15:56
 */
public class 变量捕获 {

    String s1 = "全局变量";

    // 1. 匿名内部类类型中对于变量的访问
    @Test
    public void testInnerClass() {
        String s2 = "局部变量";

        new Thread(new Runnable() {
            String s3 = "内部变量";
            @Override
            public void run() {
                // 访问全局变量
                System.out.println(变量捕获.this.s1);
                // 访问局部变量, 可获取，不可修改
                System.out.println(s2);
                // 访问内部变量
                System.out.println(this.s3);
            }
        }).start();
    }

    // 2. lambda表达式变量获取
    @Test
    public void testLambda() {
        String s2 = "局部变量lambda";

        new Thread(() -> {
            String s3 = "内部变量lambda";
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
        }).start();
    }

    @Test
    public void testFunInterface() {
        funInterface((t, r) -> t + r);
    }

    public void funInterface(MyInterface<String, String> myInterface) {
        System.out.println(myInterface.strategy("p1", "p2"));
    }

}

@FunctionalInterface
interface MyInterface<T, R> {

    R strategy(T t, R r);

}
