package demo.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月10日 16:22
 */
public class ProxyUtil<T> implements MethodInterceptor, Runnable  {

    private T target;

    public ProxyUtil(Class<T> tClass) {
        try {
            this.target = tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
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
    private static File logPath = new File(ProxyUtil.class.getResource("").getPath());
    private void recordIntervalInfo() {
        StringBuffer timeInfo = new StringBuffer();
        timeInfo.append("method[");
        timeInfo.append(theMethod.getDeclaringClass().getSimpleName())
                .append(".")
                .append(theMethod.getName());
        timeInfo.append("] Run time ");
        timeInfo.append(interval.toMillis()).append("MS. ");

        // 显示程序运行时间
        System.out.println(timeInfo.toString());

        // 将信息存入日志
//        try (FileWriter writer = new FileWriter(logPath.getAbsolutePath(), true)) {
//            writer.write(timeInfo.append("\n").toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    // 开启一条线程记录当前执行的时间
    @Override
    public void run() {
        recordIntervalInfo();
    }
}
