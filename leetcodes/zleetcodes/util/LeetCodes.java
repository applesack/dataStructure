package zleetcodes.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月18日 22:38
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LeetCodes {

    enum LEVEL {EASY, MEDIUM, HARD}; // 简单，中等，困难
    enum Status {UN_START, IN_PROGRESS, FINISHED}; // 未开始，进行中，已完成

    int id(); // 题目编号
    Status status() default Status.FINISHED; // 完成状态
    LEVEL level() default LEVEL.EASY; // 难度级别
    String[] tags() default {}; // 题目的标签
    String comment() default "[None]"; // 留言

    String createDate() default "[None]"; // 创建日期
    String finishTime() default "1h"; // 完成该题所用的时间
}
