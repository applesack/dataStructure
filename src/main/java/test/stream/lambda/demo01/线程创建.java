package test.stream.lambda.demo01;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月29日 10:57
 */
public class 线程创建 {

    public static void main(String[] args) {
        // 1.传统模式下，新线程的创建
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threading..."+Thread.currentThread().getId());
            }
        }).start();

        // 2.jdk8新特性，lambda表达式
        new Thread(() -> {
            System.out.println("threading..."+Thread.currentThread().getId());
        }).start();
    }

}
