package demo.util;

import demo.component.ErrorCommandException;
import demo.component.Interpreter;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月15日 22:56
 */
public abstract class Shell implements Interpreter {

    public Object interpret(String command) throws ErrorCommandException {
        interpret(command.split(" "));
        return null;
    }

    public final void run() {
        welcome();
        String command = "";
        while (isExitCommand(command)) {
            prompt();
            command = getInput();
            try {
                interpret(command);
            } catch (ErrorCommandException e) {
                e.printStackTrace();
            }
        }
        exit();
    }

    protected void welcome() {
        System.out.println("shell is running...");
    }

    protected void exit() {
        System.out.println("exit.");
    }

    protected void prompt() {
        System.out.print("shell> ");
    }

    protected boolean isExitCommand(String command) {
        return !command.equals(".exit");
    }

    protected abstract void interpret(String[] args) throws ErrorCommandException;

    protected abstract String getInput();

}
