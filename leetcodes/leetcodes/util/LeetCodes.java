package leetcodes.util;

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

    int id(); // 题目编号
    enum LEVEL {EASY, MEDIUM, HARD}; // 难度级别
    String[] tags() default {}; // 题目的标签
    String comment() default "[None]"; // 留言

    String createDate() default "5月18日"; // 创建日期
    String finishTime() default "1 h"; // 完成该题所用的时间
}
