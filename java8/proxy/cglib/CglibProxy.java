package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月08日 23:08
 */
public class CglibProxy<T> implements MethodInterceptor {

    private T target;

    public CglibProxy(Class<T> targetClazz) throws IllegalAccessException, InstantiationException {
        this.target = targetClazz.newInstance();
    }

    public T createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行方法前");
        Object r_val = method.invoke(target, args);
        System.out.println("执行方法后");
        return r_val;
    }

}
