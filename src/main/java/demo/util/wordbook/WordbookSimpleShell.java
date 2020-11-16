package demo.util.wordbook;

import demo.component.ConsoleColor;
import demo.component.ErrorCommandException;
import demo.util.Shell;

import java.util.Map;
import java.util.Scanner;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月15日 22:58
 */
public class WordbookSimpleShell extends Shell {

    // 默认输入方式: 键盘录入
    private final Scanner scanner = new Scanner(System.in);

    // 提示符
    private String PROMPT;

    // 上下文
    private final WordbookContext context;

    // 策略工厂
    private final CommandProcessorFactory processorFactory;

    // 策略map
    private final Map<String, CommandProcessor> processorMap;
    private final CommandProcessor errorProcessor;

    public WordbookSimpleShell() {
        context = new WordbookContext(this);
        processorFactory = new CommandProcessorFactory(context);
        processorMap = processorFactory.register();
        errorProcessor = processorMap.get("err");

        try {
            context.loadConfig();
        } catch (ErrorCommandException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void interpret(String[] args) throws ErrorCommandException {
        args = makeUpCommand(args);
        String commandName, parameter;
        switch (context.getInputMode()) {
            // 单词录入模式
            case INPUT_WORD: {
                processorMap.get("iw").process(String.join(context.getDelimiter(), args));
            } break;

            // 默写模式
            case SILENT_WRITING: {
                processorMap.get("sw").process(String.join(context.getDelimiter(), args));
            } break;

            // 默认命令模式: name1 --p=v name2 --p=v
            default: {
                int idx = 0;
                while (idx < args.length) {
                    commandName = args[0];
                    parameter = idx + 1 < args.length ? args[idx + 1] : "";

                    if (processorMap.containsKey(commandName)) {
                        processorMap.get(commandName).process(parameter);
                    } else {
                        errorProcessor.process("命令未找到");
                    }

                    idx += 2;
                }
            }
        }
    }

    // 假如命令长度不是2的倍数则用空串补齐
    private String[] makeUpCommand(String[] cmd) {
        int len = cmd.length;
        if (len % 2 == 0)
            return cmd;
        len += 1;
        String[] nCmd = new String[len];
        System.arraycopy(cmd, 0, nCmd, 0, len - 1);
        nCmd[len - 1] = "";
        return nCmd;
    }

    // 改变提示符
    protected void changePrompt(String nPrompt) {
        this.PROMPT = nPrompt;
    }

    @Override
    protected void prompt() {
        System.out.print(ConsoleColor.GRAY + PROMPT);
    }

    @Override
    protected void welcome() {
        System.out.println("lean english word ... \nenter commands");
    }

    @Override
    protected String getInput() {
        return scanner.nextLine();
    }

}
