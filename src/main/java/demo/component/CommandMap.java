package demo.component;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月16日 9:00
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CommandMap {

    String value();

}
