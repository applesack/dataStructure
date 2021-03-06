package test.stream.lambda.demo02;

/**
 * 消息传输格式化转换接口
 * @author : flutterdash@qq.com
 * @date : 2020年09月29日 11:56
 */
@FunctionalInterface
public interface IMessageFormat {

    /**
     * 消息转化方法
     * @param message 要转换的消息
     * @param format 要转换的格式[xml/json]
     * @return 返回转换后的数据
     */
    String format(String message, String format);

    /**
     * 消息合法性验证方法
     * @param msg 要验证的消息
     * @return 返回验证结果
     */
    static boolean verifyMessage(String msg) {
        return msg != null;
    }
}
