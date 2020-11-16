package demo.util.wordbook;

import demo.component.CommandMap;
import demo.component.ConsoleColor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月16日 9:05
 */
public class CommandProcessorFactory {

    private static WordbookContext context;

    private static CommandProcessorFactory INSTANCE;

    private static ClassLoader clazzLoader;

    public CommandProcessorFactory(WordbookContext context) {
        if (CommandProcessorFactory.context == null)
            CommandProcessorFactory.context = context;
        if (INSTANCE == null)
            INSTANCE = this;
        if (clazzLoader == null)
            clazzLoader = this.getClass().getClassLoader();
    }

    public Map<String, CommandProcessor> register() {
        return register(this.getClass());
    }

    // 将这个类带有@CommandMap注解的方法都注册到map中
    private Map<String, CommandProcessor> register(Class<?> factory) {
        Map<String, CommandProcessor> result = new HashMap<>();

        Method[] methods = factory.getDeclaredMethods();
        for (Method method : methods) {
            CommandMap commandMap = method.getAnnotation(CommandMap.class);
            if (commandMap == null)
                continue;
            String commandName = commandMap.value();
            if (result.containsKey(commandName))
                continue;

            // 使用动态代理生成CommandProcessor接口的实现
            Object processor = Proxy.newProxyInstance(clazzLoader,
                    new Class[]{ CommandProcessor.class },
                    ((proxy, mm, args) -> method.invoke(INSTANCE, args)));
            result.put(commandName, (CommandProcessor) processor);
        }

        return result;
    }

    // 参数为null或者为空则返回true
    private boolean checkNull(String parameter) {
        if (parameter == null || parameter.length() == 0) {
            err("缺少参数");
            return true;
        }
        return false;
    }

    // 根据分隔符来分隔
    private String[] parseArgs(String args) {
        return args.split(context.getDelimiter());
    }

    // 退出到默认模式
    private boolean exitToStandardMode(String[] args) {
        if (args.length == 1 && args[0].equals(".exit")) {
            context.changeInputMode(InputMode.STANDARD);
            return true;
        }
        return false;
    }

    @CommandMap("help")
    public void help(String parameter) {
        System.out.println("help: " + parameter);
    }

    @CommandMap("load")
    public void load(String parameter) {
        System.out.println("load: " + parameter);
    }

    @CommandMap("mode")
    public void mode(String parameter) {
        if (checkNull(parameter))
            return;
        switch (parameter) {
            case "iw":
                context.changeInputMode(InputMode.INPUT_WORD); break;
            case "sw":
                context.changeInputMode(InputMode.SILENT_WRITING);
        }
    }

    @CommandMap("iw")
    public void iw(String parameter) {
        String[] args = parseArgs(parameter);
        if (exitToStandardMode(args))
            return;

    }

    @CommandMap("sw")
    public void sw(String parameter) {
        String[] args = parseArgs(parameter);
        if (exitToStandardMode(args))
            return;
    }

    @CommandMap("err")
    public void err(String parameter) {
        System.out.println(ConsoleColor.RED + parameter);
    }

    @CommandMap(".exit")
    public void exit(String parameter) {
    }

    @CommandMap("test")
    public void test(String parameter) {

    }

}
