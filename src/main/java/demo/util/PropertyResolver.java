package demo.util;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月05日 16:28
 */
public class PropertyResolver {

    @Test
    public void testFunc() {
        // 将占位符替换成属性值
//        Student student = new Student("张三", 100, new Address("湖北", "武汉"));
//        Properties properties = new Properties();
//        properties.put("student", student);
//        properties.put("name", "学生");
//
//        String text = "${有一个${name}名字是${student.name},\n年龄是${student.age},\n在${student.address}";
//        System.out.println(resolvePlaceholders(text, properties));
    }

    /**
     * 将字符串中的占位符替换成Properties中的value
     * @param text 文本
     * @param properties 属性集，假如value是一个对象，那么key应该用符合拼写习惯的小驼峰写法，
     *                   {@code "student" -> new Student} 在引用的时候
     *                   {@code the name is ${student.name}}
     * @return 替换占位符后的文本
     */
    public static String resolvePlaceholders(CharSequence text, Map<Object, Object> properties) {
        StringBuilder sb = new StringBuilder();
        boolean isOpen = false;
        int lSign = -1;

        for (int i = 0; i<text.length(); i++) {
            char c = text.charAt(i);
            if (c == '$') {
                if (i + 1 < text.length() && text.charAt(i + 1) == '{') {

                    if (isOpen && lSign - 2 >= 0)
                        for (int j = lSign - 2; j<i; j++)
                            sb.append(text.charAt(j));

                    isOpen = true;
                    lSign = i + 2;
                    i += 1;
                    continue;
                }
            }
            if (isOpen && c == '}') {
                isOpen = false;
                if (lSign == i)
                    continue;
                String key = String.valueOf(text.subSequence(lSign, i));
                String value = getValue(key, properties, "${"+ key + "}");
                sb.append(value);
                continue;
            }
            if (!isOpen)
                sb.append(c);
        }
        return sb.toString();
    }

    private static String getValue(String key, Map<Object, Object> properties, String defaultValue) {
        Object value = properties.get(key);
        if (value != null)
            return value.toString();
        String[] fields = key.split("\\.");
        if (fields.length < 2)
            return defaultValue;

        Object obj = properties.get(fields[0]);
        if (obj == null)
            return defaultValue;
        String[] res = new String[1];
        if (dfs(obj, fields, 1, res))
            return res[0];
        else
            return defaultValue;
    }

    private static boolean dfs(Object obj, String[] fields, int idx, String[] res) {
        if (idx == fields.length) {
            res[0] = obj.toString();
            return true;
        }

        Class<?> clazz = obj.getClass();
        try {
            Field field = clazz.getDeclaredField(fields[idx]);
            field.setAccessible(true);
            Object fieldObj = field.get(obj);
            return dfs(fieldObj, fields, idx + 1, res);
        } catch (Exception e) {
            return false;
        }
    }
}
