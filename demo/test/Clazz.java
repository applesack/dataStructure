package test;

import org.w3c.dom.CharacterData;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年07月03日 21:14
 */
public class Clazz {

    private static int[] arr = new int[]{1,2,24,5};

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class<Clazz> clazz = Clazz.class;
        Field field = clazz.getDeclaredField("arr");
        field.setAccessible(true);
        int[] narr = (int[]) field.get(null);
        System.out.println(Arrays.toString(narr));

//        System.out.println(isAllRound(String.class, java.io.Serializable.class,
//                                                                Comparable.class,
//                                                                CharSequence.class));
    }

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
