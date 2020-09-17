package test.version_feature.java11;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月17日 14:24
 */
public class 字符串加强 {

    public static void main(String[] args) {
        " ".isBlank(); // 判断字符串是否为空白
        "  JAVA ".strip(); // 去除首尾空格
        "  JAVA".stripLeading(); // 去除首部空格
        "JAVA  ".stripTrailing(); // 去除尾部空格
        "JAVA".repeat(3); // 重复复制字符串
        "A\nB\nC\n".lines().count(); // 行数统计
    }
}
