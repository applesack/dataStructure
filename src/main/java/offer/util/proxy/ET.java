package offer.util.proxy;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月10日 11:13
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 记录方法执行的时间
 */
public class ET<T> implements MethodInterceptor, Runnable {

    private T target;

    public ET(Class<T> tClass) {
        try {
            this.target = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public T getInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Instant start = Instant.now();
        Object r_value = method.invoke(target, args);
        Instant end = Instant.now();

        interval = Duration.between(start, end);
        theMethod = method;

        new Thread(this).start();
        return r_value;
    }

    // 将方法执行信息显示并存入日志
    private Duration interval;
    private Method theMethod;
    public void recordIntervalInfo() {
        StringBuffer timeInfo = new StringBuffer();
        timeInfo.append("method[");
        timeInfo.append(theMethod.getName());
        timeInfo.append("] Run time ");
        timeInfo.append(interval.toMillis()).append("MS. ");

        System.out.println(timeInfo.toString());
    }

    // 开启一条线程记录当前执行的时间
    @Override
    public void run() {
        recordIntervalInfo();
    }
}
