package demo.util.IdiomSolitaire.command;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月26日 20:13
 */
public abstract class Interpreter {

    private String commandName = null;

    // 解释
    abstract void interpreter(int index);

    // 执行
    abstract void execution();

    public boolean isCatch(String commandName) {
        return commandName.equals(this.commandName);
    }

}
