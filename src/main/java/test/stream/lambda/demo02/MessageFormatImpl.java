package test.stream.lambda.demo02;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月29日 12:10
 */
public class MessageFormatImpl implements IMessageFormat {
    @Override
    public String format(String message, String format) {
        System.out.println("消息转换...");
        return message;
    }
}
