package proxy.cglib;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月08日 23:12
 */
public class Test {

    @org.junit.Test
    public void Test() throws InstantiationException, IllegalAccessException {
        Hello hello = (Hello) new CglibProxy(Hello.class).createCglibProxy();
//        hello.Say();
//        hello.Run();
        System.out.println(hello.returnValIs5());
    }

    public static void main(String[] args) {
        System.out.println("1111");
    }
}
