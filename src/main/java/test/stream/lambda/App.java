package test.stream.lambda;

import org.junit.Test;
import test.stream.lambda.demo02.IMessageFormat;
import test.stream.lambda.demo02.MessageFormatImpl;

import java.util.UUID;
import java.util.function.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月29日 12:12
 */
public class App {

    public static void main(String[] args) {
        IMessageFormat format = new MessageFormatImpl();

        format.format("hello", "json");
    }

    @Test
    public void testPredicate() {
        Predicate<String> pre = "admin"::equals;
        Consumer<String> consumer = (String message) -> {
            System.out.println("要发送的消息");
        };

        Function<String, Integer> func = (String gender) -> {
            return "male".equals(gender) ? 1 : 0;
        };

        // 获取系统密钥
        Supplier<String> sup = () -> UUID.randomUUID().toString();
        System.out.println(sup.get());

        UnaryOperator<String> uo = (String img) -> {
            return img += "[100x200]";
        };

        BinaryOperator<Integer> bo = (Integer i1, Integer i2) -> {
            return i1 > i2 ? i1 : i2;
        };

    }

}
