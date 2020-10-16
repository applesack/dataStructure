package leetcodes.nums.p1_200;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月12日 23:04
 */
public class P71 {

    @Test
    public void testFunc() {
        String input =
//                "/home/"
//                "/a/../../b/../c//.//"
                "/home//foo/"
                ;
        System.out.println(simplifyPath(input));
    }

    /**
     * 用文件分隔符将路径分隔开，例如"/home//foo"被分隔成["home", "foo"]
     * 然后将数组中的每个元素压入栈中，再用文件分隔符将其拼接返回
     * 其中遇到"."或者""则忽略。遇到".."则从栈中弹出一个数据(模拟上一个目录)
     *
     * @param path 需要被简化的路径，以文件分隔符开头，以文件分隔符结尾
     * @return 返回简化后的文件路径
     */
    public String simplifyPath(String path) {
        // 文件分隔符 File.pathSeparator
        final String separator = "/";
        Stack<String> stack = new Stack<>();
        String[] fileItem = path.split(separator);
        for (String str : fileItem) {
            if (!(str.length() == 0 || str.equals(".") || str.equals(".."))) {
                stack.push(str);
            }
            if (!stack.isEmpty() && str.equals("..")) {
                stack.pop();
            }
        }

        return "/" + String.join(separator, stack);
    }

}
