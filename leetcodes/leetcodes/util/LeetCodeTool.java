package leetcodes.util;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月19日 8:31
 */
public class LeetCodeTool implements Runnable {

    private final String pack = "leetcodes"; // 指定读取`leetcode`包下的所以.class文件
    private ArrayList<Class<?>> examples; // 存放含有`LeetCodes`注解的Class对象

    // 初始化
    public void init() {
        printLine();
        System.err.println("初始化, 包名: '" + pack + "' >");
        Set<Class<?>> tempSet = ClassTool.getClasses(pack);
        System.out.println("扫描到.class文件 " + tempSet.size() + " 个.");

        examples = new ArrayList<>();
        Iterator<Class<?>> iterator = tempSet.iterator();
        Class<?> tempClass;
        while (iterator.hasNext()) {
            tempClass = iterator.next();

            // 检查这个Class对象有没有LeetCodes注解
            LeetCodes a = tempClass.getAnnotation(LeetCodes.class);
            if (a != null) {
                examples.add(tempClass);
            }
        }

        // 统计
        statistics(examples);

        // 输入命令
        commands();
    }

    // 循环输入命令 执行命令
    private void commands() {

        Scanner scanner = new Scanner(System.in);
        String cmd_name; // 命令的名字
        String cmd_val; // 命令的值
        String[] tempStr; // 接收命令


        while (true) {
            cmd_val = ""; // 初始化命令值

            System.out.print("command> ");
            tempStr = scanner.nextLine().toLowerCase().split(" ");

            if (tempStr.length > 2 || tempStr.length == 0)
                continue;
            if (tempStr.length == 2)
                cmd_val = tempStr[1];
            cmd_name = tempStr[0];

            switch (cmd_name) {
                case "help":
                    help(cmd_val);
                    break;
                case "list":
                    list(cmd_val);
                    break;
                case "info":
                    info(cmd_val);
                    break;
                case "test":
                    test(cmd_val);
                    break;
                case "tags":
                    tags(cmd_val);
                    break;
                case "reload":
                    reload();
                    return; // 选择重新载入后退出本方法
                case "exit":
                    System.err.println("正在退出");
                    System.exit(0);
                    break;
                default:
                    System.err.println("没有这个命令!! `" + cmd_name + "`");
                    break;
            }

            scanner.nextLine(); // 输入回车后进行下一条命令
            printLine();
        }
    }

    // 统计信息
    private void statistics(ArrayList<Class<?>> examples) {
        System.out.println("检查到打有@LeetCodes注解的.class文件有 " + examples.size() + " 个");

        /**
         *      0     1     2
         * 0   简单   中等   困难
         * 1  进行中  进行中 进行中
         * 2  已完成  已完成 已完成
         */
        int[][] example_info = new int[3][3];

        for (int i = 0; i < examples.size(); i++) {
            Class<?> tempClass = examples.get(i);
            LeetCodes a = tempClass.getAnnotation(LeetCodes.class);

            int level = -1; // 默认难度级别
            switch (a.level()) { // 难度级别
                case EASY:
                    level = 0;
                    example_info[0][level] += 1;
                    break;
                case MEDIUM:
                    level = 1;
                    example_info[0][level] += 1;
                    break;
                case HARD:
                    level = 2;
                    example_info[0][level] += 1;
                    break;
                default:
                    break;
            }

            if (level == -1) continue;

            switch (a.status()) { // 完成情况
                case UN_START:
                    example_info[1][level] += 1;
                    break;
                case IN_PROGRESS:
                    example_info[1][level] += 1;
                    break;
                case FINISHED:
                    example_info[2][level] += 1;
                    break;
                default:
                    break;
            }
        }

        System.out.println("其中");
        System.out.println("    简单:" + example_info[0][0] + "\t 完成:" + example_info[2][0] + "\t  未完成:" + example_info[1][0]);
        System.out.println("    中等:" + example_info[0][1] + "\t 完成:" + example_info[2][1] + "\t  未完成:" + example_info[1][1]);
        System.out.println("    困难:" + example_info[0][2] + "\t 完成:" + example_info[2][2] + "\t  未完成:" + example_info[1][2]);
        printLine();
    }

    /**
     * 输出cmd代表的难度级别的题目id
     * 具体如何使用 请输入命令 help list
     *
     * @param cmd
     */
    private void list(String cmd) {
        LeetCodes.LEVEL level = null;

        System.out.print("\nvalue: ");
        if (cmd.equals("") || cmd.equals("all")) {
            level = null;
        } else if (cmd.equals("easy")) {
            level = LeetCodes.LEVEL.EASY;
        } else if (cmd.equals("medium")) {
            level = LeetCodes.LEVEL.MEDIUM;
        } else if (cmd.equals("hard")) {
            level = LeetCodes.LEVEL.HARD;
        }
        System.out.println(level == null ? "all" : level.name() + "\n");

        ArrayList<Class<?>> example_list = new ArrayList<>();
        for (Class<?> item : examples) {
            LeetCodes a = item.getAnnotation(LeetCodes.class);
            if (level == null) {
                example_list.add(item);
            } else if (level == a.level()) {
                example_list.add(item);
            }
        }

        // 给Class数组排序后输出
        example_list.sort((x, y) -> {
            // 根据注解中的编号大小进行排序
            LeetCodes a = x.getAnnotation(LeetCodes.class);
            LeetCodes b = y.getAnnotation(LeetCodes.class);

            return (a.id() - b.id());
        });

        for (Class<?> example : example_list) {
            printSimple(example);
        }

        System.out.println("总数: " + example_list.size());
    }

    /**
     * 输出cmd(是整数)
     * 具体使用 请输入 help info
     *
     * @param cmd
     */
    private void info(String cmd) {
        Integer id = StringToInteger(cmd);
        if (id == -1) return; // cmd参数无效

        try {
            Class<?> example = getClassById(id);
            // 先输出题目
            printSimple(example);

            LeetCodes a = example.getAnnotation(LeetCodes.class);
            printMessage(a);
        } catch (Exception e) { // id 在本地不存在
            e.printStackTrace();
        }
    }

    /**
     * 运行cmd所指的Class文件的Run方法
     * 具体使用请输入 help test
     * @param cmd
     */
    private void test(String cmd) {
        Integer id = StringToInteger(cmd);
        if (id == -1) return; // cmd参数无效

        Method RunMethod = null;
        try {
            Class<?> example = getClassById(id);
            printSimple(example);
            for (Method m : example.getDeclaredMethods()) {
                if (m.getName().equals("Run")) {
                    RunMethod = m;
                    break;
                }
            }
            if (RunMethod != null) {
                RunMethod.setAccessible(true);
                RunMethod.invoke(example.newInstance(), null);
                return;
            } else {
                System.err.println("该类不含有名为`Run`的方法，无法执行");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据标签查找匹配的类对象
     * @param cmd
     */
    private void tags(String cmd) {
        String[] list = cmd.split(",|，");
        if (list.length == 1 && list[0].equals("")) {
            list("");
            return;
        }

        List<Class<?>> matchExamples = getClassByTags(list);
        if (matchExamples.size() == 0) {
            System.err.println("没找到包含此标签的文件");
        } else {
            for (int i = 0; i<matchExamples.size(); i++) {
                printSimple(matchExamples.get(i));
            }
        }
    }

    /**
     * 输出注解上的信息
     * @param example 一个@LeetCodes注解
     */
    private void printMessage(LeetCodes example) {
        System.out.println("    题目ID: " + example.id());
        System.out.println("    完成状态: " + example.status().name());
        System.out.println("    难度级别: " + example.level().name());
        System.out.println("    标签: " + Arrays.toString(example.tags()) + "\n");

        System.out.println("    创建时间:  " + example.createDate());
        System.out.println("    完成时间: " + example.finishTime());
        System.out.println("    留言: " + example.comment());
        System.out.println("######################################");
    }

    /**
     * 输出一个题目的简要信息
     *
     * @param example 题目的代码所在的Class对象
     */
    private void printSimple(Class<?> example) {
        // 编号
        LeetCodes a = example.getAnnotation(LeetCodes.class);
        int id = a.id();
        System.out.printf("#%-3d\t", id);

        String[] exampleName = example.getName().split("\\.");
        System.out.println("::" + exampleName[exampleName.length - 1] + "::");
    }

    /**
     * 根据给定的标签查找对应的类对象
     * @return
     */
    private List<Class<?>> getClassByTags(String[] tags) {
        List<Class<?>> classList = new ArrayList<>();
        String[] objTags;
        for (int i = 0; i<examples.size(); i++) {
            LeetCodes a = examples.get(i).getAnnotation(LeetCodes.class);
            if (a.tags().length != 0) {
                if (matchTags(a.tags(), tags))
                    classList.add(examples.get(i));
            }
        }
        return classList;
    }
    // 匹配两个标签数组，当outer的标签全部包含inner的标签返回true，否则返回false
    private boolean matchTags(String[] outer, String[] inner) {

        for (String in : inner) {
            boolean result = false;
            for (String out : outer) {
                if (out.equals(in)) {
                    result = true;
                    break;
                }
            }
            if (!result)
                return false;
        }
        return true;
    }

    @Test
    public void Test() {
        String[] outer = {"abd", "aec", "axc"};
        String[] inner = {"abc"};
        System.out.println(matchTags(outer, inner));
    }

    /**
     * 根据id找到本地对应的Class对象
     * @param id 题目的id
     * @return 对应的Class对象
     * @throws Exception 当本地不存在这个id, 则抛出异常
     */
    private Class<?> getClassById(int id) throws Exception {

        Class<?> result = null;
        for (int i = 0; i < examples.size(); i++) {
            LeetCodes a = examples.get(i).getAnnotation(LeetCodes.class);
            if (a.id() == id) {
                result = examples.get(i);
                break;
            }
        }
        if (result == null)
            throw new Exception("题号 `" + id + "` 在本地不存在");
        return result;
    }

    /**
     * 重新加载Class类文件
     */
    private void reload() {
        System.err.println("重新载入");
        init();
    }

    /**
     * 把字符串转换成数字
     *
     * @param str 被转换的字符串必须是正整数，不含其他符号
     * @return 转换后的整型数字
     */
    public static int StringToInteger(String str) {
        Integer id;
        try { // 先将cmd字符串转换成数字
            try {
                id = new Integer(str);
            } catch (Exception e) {
                System.err.println("输入的命令 `" + str + "` 不能被转换成数字");
                return -1;
            }
            if (id <= 0)
                throw new Exception("输入的命令 `" + str + "` 不是有效的数字");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {

        }
        return id;
    }

    /**
     * 使用帮助
     *
     * @param cmd
     */
    private void help(String cmd) {
        if (cmd.equals("")) {

            System.out.println(ToolInfo.Help()); // 显示帮助
            return;
        }

        // 显示具体的命令信息
        ToolInfo.switchCMD(cmd);
    }

    private void printLine() {
        System.out.println("--------------------------------------");
    }

    @Override
    public void run() {
        init();
    }

    public LeetCodeTool() {
    }

    public static void main(String[] args) {
        LeetCodeTool tool = new LeetCodeTool();
        tool.init();
    }
}
