package util;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月10日 20:17
 */
public class ClazzUtil {

    @Test
    public void testFunc() {
        int[] from = {1,2,3,4};
        int[] desc = new int[from.length + 1];
        System.arraycopy(from, 0, desc, 1, 4);
        System.out.println(Arrays.toString(desc));
    }

    @lombok.SneakyThrows
    public static <T> T getInstance(Class<T> clazz) {
        return getInstance(clazz, null);
    }

    /**
     * 根据参数生成类的实例，暂时不支持静态内部类
     * @param clazz
     * @param args
     * @param <T>
     * @return
     */
    @lombok.SneakyThrows
    public static <T> T getInstance(Class<T> clazz, Object ... args) {
        Class<?>[] argTypeList = null;
        Class<?> outerClazz = null;
        String theClazzName = clazz.getName();

        // 判断是否是内部类
        int delimiter_index = theClazzName.indexOf('$');
        if (delimiter_index != -1) {
            String outClazzName = theClazzName.substring(0, delimiter_index);
            outerClazz = clazz.getClassLoader().loadClass(outClazzName);
            argTypeList = new Class[args == null ? 1 : args.length];

            if (args == null) return clazz.getConstructor(outerClazz)
                    .newInstance(getInstance(outerClazz));
        } else {
            if (args == null)
                return clazz.newInstance();
        }

        // 获取参数的实际类型
        for (int i = 0; i<args.length; i++) {
            // 是包装类，拆箱
            if (args[i].getClass().getSuperclass().equals(Number.class)) {
                argTypeList[i] = unboxing(args[i].getClass());
            } else {
                argTypeList[i] = args[i].getClass();
            }
        }

        // 生成构造器的参数
        Object[] parameters;
        if (outerClazz != null) {
            Class[] res = new Class[argTypeList.length + 1];
            System.arraycopy(argTypeList, 0, res, 1, argTypeList.length);
            res[0] = outerClazz;
            argTypeList = res;

            // 生成参数
            parameters = new Object[args.length + 1];
            parameters[0] = getInstance(outerClazz);
            for (int i = 1; i<parameters.length; i++) {
                parameters[i] = args[i-1];
            }
        } else {
            parameters = args;
        }

        T instance = null;

        try {
            Constructor<T> constructor = clazz.getConstructor(argTypeList);
            constructor.setAccessible(true);
            instance = constructor.newInstance(parameters);
        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();

            // 打印错误信息
            throw new NoSuchMethodException(
                    Arrays.toString(
                    Arrays.stream(argTypeList)
                            .map(Class::getSimpleName)
                            .toArray(String[]::new))
            );
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        return instance;
    }

    /**
     * 将包装类型拆箱成基础类型
     * @param clazz 包装类
     * @return
     */
    private static Class<?> unboxing(Class<?> clazz) {
        String className = clazz.getSimpleName();
        switch (className) {
            case "Integer":
                return int.class;
            case "Character":
                return char.class;
            case "Double":
                return double.class;
            case "Long":
                return long.class;
            case "Short":
                return short.class;
            case "Byte":
                return byte.class;
            default:
                return void.class;
        }
    }

    /**
     * 判断一个类是否实现了指定的接口
     * @param clazz 要进行判断的类
     * @param interfaceList 要求类要实现的接口
     * @param <T> Clazz的类型
     * @return 实现了目标接口 true 没有全部实现 false
     */
    public static <T> boolean isAllRound(Class<T> clazz, Class ... interfaceList) {
        // 获取类对象的所有接口,然后排序，转成数组
        String[] ability = Arrays.stream(clazz.getInterfaces())
                .map(Class::getSimpleName)
                .sorted(String::compareTo)
                .toArray(String[]::new);
        String[] require =  Arrays.stream(interfaceList)
                .map(Class::getSimpleName)
                .sorted(String::compareTo)
                .toArray(String[]::new);
        // 假如和需要实现的接口不匹配，则返回false
        for (int index=0; index<require.length; index++) {
            if (require[index].compareTo(ability[index]) != 0)
                return false;
        }

        return true;
    }
}
