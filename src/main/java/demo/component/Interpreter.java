package demo.component;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月15日 23:10
 */
@FunctionalInterface
public interface Interpreter {

    Object interpret(String command) throws ErrorCommandException;

}
