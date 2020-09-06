package offer.part2;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月03日 15:08
 */
public class P12 {
    /**
     * 回溯法
     */

    @Test
    public void testFunc() {
        char[][] input = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };

        String[] targetArr = {
                "btcs",
                "bfce",
                "abfb"
        };

        for (String target : targetArr) {
            System.out.println(hasPath(input, target) + "\t " + target);
        }
    }

    private boolean hasPath(char[][] matrix, String target) {
        if (matrix == null) return false;
        if (target == null) return false;
        if (target.equals("")) return true;

        int row = matrix.length;
        int column = matrix[0].length;

        char[] targetCharArr = target.toCharArray();
        for (int r = 0; r<row; r++) {
            for (int c = 0; c<column; c++) {
                if (matrix[r][c] == targetCharArr[0])
                    if (hasPath(matrix, r, c, targetCharArr, 1, new boolean[row][column]))
                        return true;
            }
        }
        return false;
    }

    private static int count = 1;

    /**
     * 检查以匹配字符的数量，假如这个数量和目标字符串的长度相同，表示所有字符已匹配完成，返回true
     * 根据参数中的坐标，查看以该坐标为中心，上下左右中，是否存在一个位置不越界且能匹配到下一个目标字符
     * 如果有这个位置，则递归调用本函数继续匹配下一个目标字符，并在参数中修改下一个位置的坐标
     * 假如没有这个位置，则当前线索完全中断，返回false
     *
     * @param matrix 地图，由字符构成的二维数组
     * @param r 当前的横坐标
     * @param c 当前的纵坐标
     * @param target 目标字符串的字符数组
     * @param hasMatch 已经匹配到了第几个字符
     * @param path 记录地图上走过的路径，每当到达一个坐标，将这个坐标标记为true，表示来过这个位置
     * @return 返回以该坐标为起点是否存在包含目标字符串的路径
     */
    private boolean hasPath(char[][] matrix, int r, int c, char[] target, int hasMatch, boolean[][] path) {
//        System.out.println("第"+count+++"次, 当前坐标["+r+", "+c+"]");

        if (hasMatch == target.length)
            return true;

        // 上
        if ((r - 1) >= 0 && path[r-1][c] == false) {
            if (matrix[r-1][c] == target[hasMatch]) {
                path[r-1][c] = true;
                if (hasPath(matrix, r-1, c, target, hasMatch+1, path))
                    return true;
            }
        }

        // 右
        if ((c + 1) < matrix[r].length && path[r][c+1] == false) {
            if (matrix[r][c+1] == target[hasMatch]) {
                path[r][c+1] = true;
                if (hasPath(matrix, r, c+1, target, hasMatch+1, path))
                    return true;
            }
        }

        // 下
        if ((r + 1) < matrix.length && path[r+1][c] == false) {
            if (matrix[r+1][c] == target[hasMatch]) {
                path[r+1][c] = true;
                if (hasPath(matrix, r+1, c, target, hasMatch+1, path))
                    return true;
            }
        }

        // 左
        if ((c - 1) >= 0 && path[r][c-1] == false) {
            if (matrix[r][c-1] == target[hasMatch]) {
                path[r][c-1] = true;
                if (hasPath(matrix, r, c-1, target, hasMatch+1, path))
                    return true;
            }
        }

        return false;
    }
}
