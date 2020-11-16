package test.proxy.jdk;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月16日 10:55
 */
public class Factory {

    public void runTest() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        Factory object = new Factory();
        Method method = null;
        try {
            method = object.getClass().getDeclaredMethod("runTest");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (method == null)
            return;
        Method finalMethod = method;
        TestInterface testInterface = (TestInterface) Proxy.newProxyInstance(null,
                new Class[]{ Factory.class },
                ((proxy, mm, args1) -> finalMethod.invoke(object, args)));

        testInterface.run();
    }

}
