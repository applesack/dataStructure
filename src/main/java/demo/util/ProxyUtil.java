package demo.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年08月10日 16:22
 */
@Slf4j
public class ProxyUtil implements MethodInterceptor {

    private Object target;

    private PreAction preAction = defaultPreAction();

    private PostAction postAction = defaultPostAction();

    public ProxyUtil(Class<?> tClass) {
        try {
            this.target = tClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object getInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 调用前置方法，接收前置方法所返回的对象
        Object preRes = preAction.action(obj, method, args);

        // 执行方法
        Object mRes = method.invoke(target, args);

        // 调用后置方法，结合前置方法返回的对象进行处理
        postAction.action(obj, method, args, mRes, preRes);

        // 返回方法的结果
        return mRes;
    }

    // 返回默认的前置方法，这个方法返回一个记录方法执行前的时间对象
    private static PreAction defaultPreAction() {
        return (obj, method, args) -> Instant.now();
    }

    // 返回默认的后置方法，这个方法结合前置方法返回的时间输出这个方法执行所消耗的时间
    private static PostAction defaultPostAction() {
        return (obj, method, args, methodRes, preRes) -> {
            if (!(preRes instanceof Instant))
                return;
            Instant start = (Instant) preRes;
            Instant end = Instant.now();
            Duration interval = Duration.between(start, end);
            // 显示方法运行时间
            String timeInfo = "method[" +
                    method.getDeclaringClass().getSimpleName() +
                    "." +
                    method.getName() +
                    "] Run time " +
                    interval.toMillis() + "MS. ";
            System.out.println(timeInfo);
        };
    }

    public void setPreAction(PreAction preAction) {
        if (preAction == null)
            return;
        this.preAction = preAction;
    }

    public void setPostAction(PostAction postAction) {
        if (postAction == null)
            return;
        this.postAction = postAction;
    }

    @FunctionalInterface
    public interface PreAction {
        /**
         * 在方法调用之前被执行
         * @param obj 调用方法的对象
         * @param method 方法对象
         * @param args 方法参数
         * @return 这里返回的对象与实际方法返回的对象无关，仅供后置方法调用
         */
        Object action(Object obj, Method method, Object[] args);
    }

    @FunctionalInterface
    public interface PostAction {
        /**
         * 在方法调用之后执行
         * @param obj 调用方法的对象
         * @param method 方法对象
         * @param args 方法参数
         * @param methodResult 方法对象调用后的返回值
         * @param preResult 前置方法执行的返回值
         */
        void action(Object obj, Method method, Object[] args, Object methodResult, Object preResult);
    }
}
