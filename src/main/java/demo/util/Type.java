package demo.util;

/**
 * 与SQL数据表的字段对应，
 * 可以增加一些其他特殊的字段类型，但需要在特定的地方给出实现
 *
 * @author : flutterdash@qq.com
 * @since : 2020年10月29日 19:06
 */
public enum Type {

    // 字符类型
    STRING,

    // 整型
    INTEGER,

    // 单精度浮点
    FLOAT,

    // 双精度浮点
    DOUBLE,

    // 日期类型
    DATE,

    // 默认
    DEFAULT

}
