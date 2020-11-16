package demo.util.wordbook;

import demo.component.ErrorCommandException;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月16日 9:06
 */
@FunctionalInterface
public interface CommandProcessor {

    void process(String parameter) throws ErrorCommandException;

}
