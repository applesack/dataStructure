package leetcodes.util;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月19日 16:11
 */
public class ToolInfo {
    /**
     * 单独开一个类来写工具的使用
     */

    private static String title = "::工具说明::\n";
    private static String toolList =
            "   1.help 显示帮助\n" +
                    "   2.list 输出本地已经存在的题目编号\n" +
                    "   3.info 具体输出本地指定题目的信息\n" +
                    "   4.test 测试本地已经存在的题目代码\n" +
                    "   5.reload 重新加载\n";

    // 返回命令列表
    public static String Help() {
        return title + toolList;
    }

    public static void switchCMD(String cmd) {
        switch (cmd) {
            case "help":
                System.out.println(help);
                break;
            case "list":
                System.out.println(list);
                break;
            case "info":
                System.out.println(info);
                break;
            case "test":
                System.out.println(test);
                break;
            case "reload":
                System.out.println(reload);
                break;
            default:
                System.err.println("暂时不支持该功能");
                break;
        }
    }

    private static String help =
            "::help-帮助::\n" +
            "参数只能有一个，是要查找的工具的名字，例如\n" +
            "help help\n" +
            "这就是查找help这个命令的使用帮助，其他以此类推\n";

    private static String list =
            "::list-查看本地已经存在的题目编号::\n" +
            "参数只有一个，有四种\n" +
            "easy   查看本地存在的难度为easy的题目编号\n" +
            "medium 查看本地存在的难度为medium的题目编号\n" +
            "hard   查看本地存在的难度为hard的题目编号\n" +
            "all    查看本地所有的题目编号\n" +
            "当list后没有参数，默认当all处理\n";

    private static String info =
            "::info-题的信息::\n" +
            "参数只有一个，是题的编号\n" +
            "当输入的编号在本地不存在，则无法显示\n" +
            "使用例: info 3\n";

    private static String test =
            "::test-测试代码::\n" +
            "参数只有一个，即题目的编号\n" +
            "输入题目的编号即可运行对应的代码\n" +
            "例如 test 2 运行第二题的代码\n" +
            "但是可能因为指定的类里没有名为Run的方法而运行错误\n";

    private static String reload =
            "::reload-重新加载::\n" +
            "无参数\n" +
            "重新加载包下的.class类文件\n" +
            "在有新的.class文件加入的时候使用\n"                ;

}
