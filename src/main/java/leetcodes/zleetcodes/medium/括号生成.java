package leetcodes.zleetcodes.medium;

import leetcodes.zleetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月21日 17:15
 */

@LeetCodes(
        id = 22,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.FINISHED,
        tags = {"深度优先遍历"},
        createDate = "2020/05/21",
        finishTime = "1h"
)
public class 括号生成 {

    // 解法一: 深度优先遍历
    public static List<String> generateParenthesis1(int n) {

        List<String> res =  new ArrayList<>();

        if (n == 0) return res;

        dfs("", n, n, res);
        return res;
    }

    /**
     * 深度优先遍历
     * @param curStr 当前递归得到的结果
     * @param left 左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     * @param res 结果集
     */
    private static void dfs(String curStr, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        if (left > right) // 当剩余的左括号多于右括号
            return;
        if (left > 0) {
            dfs(curStr+"(", left-1, right, res);
        }
        if (right > 0) {
            dfs(curStr+")", left, right-1, res);
        }
    }

    public List<String> generateParenthesis2(int n) {
        return null;
    }

    @Test
    public void Run() {
        int input = 3;
        System.out.println("输入: " + input);
        System.out.println("输出: " + generateParenthesis1(input));
    }
}
