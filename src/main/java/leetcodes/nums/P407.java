package leetcodes.nums;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月11日 10:14
 */
public class P407 {

    @Test
    public void testFunc() {
        int[][] in = {
//                {1, 4, 3, 1, 3, 2},
//                {3, 2, 1, 3, 2, 4},
//                {2, 3, 3, 2, 3, 1}

                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(trapRainWater(in));
    }

    public int trapRainWater(int[][] heightMap) {
        // 当长度或者宽度 <= 2 到时候，是无法接住雨水的，返回0
        int width = heightMap[0].length;
        int length = heightMap.length;
        if (width <= 2 || length <= 2)
            return 0;

        // 最外一圈无法接住雨水，所以从内圈开始计算
        // 获取内圈的范围
        int innerWid = width - 1;
        int innerLen = length - 1;
        int start = 1; // 二维数组起始为1的地方

        // 找到内圈中地势最低和最高的地方
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int r = start; r<innerLen; r++) {
            for (int c = start; c<innerWid; c++) {
                if (heightMap[r][c] < min) {
                    min = heightMap[r][c];
                } else if (heightMap[r][c] > max) {
                    max = heightMap[r][c];
                }
            }
            max = Math.max(max,  Math.max(heightMap[r][0], heightMap[r][innerWid]));
        }
        max = Math.max(Arrays.stream(heightMap[0]).max().getAsInt(),
                Arrays.stream(heightMap[innerLen]).max().getAsInt());

        // 当前层是内圈最地势最低的层，从这里开始计算
        int curDiv = min + 1;
        int sumOfValue = 0, curVal;
        boolean[][] tmp = new boolean[length][width];
        while (curDiv <= max) {
            clear(tmp);
            // 扫描这一层，直到发现
            System.out.println("第" + curDiv + "层");
            for (int r = 1; r<innerLen; r++) {
                for (int c = 1; c<innerWid; c++) {
                    if (heightMap[r][c] <= curDiv) {
                        curVal = getValueOfDiv(heightMap, r, c, curDiv, 1, tmp);
                        if (curVal > 0) {
                            sumOfValue += curVal;
                        }
                    }
                }
            }

            curDiv += 1;
        }

        return sumOfValue;
    }

    private int getValueOfDiv(int[][] heightMap, int r, int c, int curDivValue,
                              int sum, boolean[][] tmp) {
        if (tmp[r][c])
            return sum;
        tmp[r][c] = true;

        System.out.println("r:" + r + ", c:" + c);

        // 检查上方位置是否可以移动
        if (r - 1 >= 1 && !tmp[r - 1][c]) {
            if (heightMap[r - 1][c] < curDivValue) {
                sum = getValueOfDiv(heightMap, r - 1, c, curDivValue, sum + 1, tmp);
            }
        } else {
            if (r - 1 == 0 && heightMap[r - 1][c] < curDivValue)
                return -1;
        }
        if (sum == -1) return sum;

        // 检查下方
        if (r + 1 < heightMap.length - 1 && !tmp[r + 1][c]) {
            if (heightMap[r + 1][c] < curDivValue) {
                sum = getValueOfDiv(heightMap, r + 1, c, curDivValue, sum + 1, tmp);
            }
        } else {
            if (r + 1 == heightMap.length - 1 && heightMap[r + 1][c] < curDivValue)
                return -1;
        }
        if (sum == -1) return sum;

        // 检查左
        if (c - 1 >= 1 && !tmp[r][c - 1]) {
            if (heightMap[r][c - 1] < curDivValue) {
                sum = getValueOfDiv(heightMap, r, c - 1, curDivValue, sum + 1, tmp);
            }
        } else {
            if (c - 1 == 0 && heightMap[r][c - 1] < curDivValue)
                return -1;
        }
        if (sum == -1) return sum;

        // 检查右
        if (c + 1 < heightMap[0].length - 1 && !tmp[r][c + 1]) {
            if (heightMap[r][c + 1] < curDivValue) {
                sum = getValueOfDiv(heightMap, r, c + 1, curDivValue, sum + 1, tmp);
            }
        } else {
            if (c + 1 == heightMap[0].length - 1 && heightMap[r][c + 1] < curDivValue)
                return -1;
        }

        return sum;
    }

    private void clear(boolean[][] map) {
        for (int i = 1; i<map.length-1; i++) {
            for (int j = 1; j<map[0].length - 1; j++) {
                if (map[i][j])
                    map[i][j] = false;
            }
        }
    }
}
