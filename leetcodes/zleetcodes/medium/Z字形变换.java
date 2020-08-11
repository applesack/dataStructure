package zleetcodes.medium;

import zleetcodes.util.LeetCodes;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月20日 21:18
 */

@LeetCodes(
        id = 6,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.FINISHED,
        tags = {"字符串"},
        createDate = "2020/05/20",
        finishTime = "1h22m"
)
public class Z字形变换 {

    /**
     * ::Z字形变换::
     * 选择数组做为存储临时信息的方式，
     * 奇数列为numRows个，偶数列则为numRows-2个
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        // 空判断
        if (s.length() <= 1 || numRows == 1) return s;

        int i,j;
        int row; // 行
        int column; // 列

        // 计算需要多少列来存放数据

        column = (int) Math.ceil((float) s.length()/(numRows*2-1)*numRows);
        char[][] tmp = new char[numRows][column]; // 创建二维数组

        // false上行  true下行
        boolean isDown = true;

        // 存入数组
        row = column = 0;
        for (i = 0; i<s.length(); i++) {
            tmp[row][column] = s.charAt(i);
            if (isDown) { // 下行

                if (row == numRows-1) {
                    isDown = false;
                    row --;
                    column++;
                } else {
                    row++;
                }
            } else { // 上行

                if (row == 0) {
                    row++;
                    isDown = true;
                } else {
                    row--;
                    column++;
                }
            }
        }

        // 查看数组里的元素
        for (i = 0; i<numRows; i++) {
            System.out.println(Arrays.toString(tmp[i]));
        }

        // 从数组里取出
        StringBuffer result = new StringBuffer();
        for (i = 0; i<numRows; i++) {
            for (j = 0; j<tmp[0].length; j++) {
                if (tmp[i][j] != '\u0000')
                result.append(tmp[i][j]);
            }
        }

        return result.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows < 2)
            return s;

        List<StringBuffer> rows = new ArrayList<StringBuffer>();
        int i, flag;

        for (i = 0; i<numRows; i++) rows.add(new StringBuffer());

        i = 0;
        flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows-1)
                flag = -flag;
            i += flag;
        }

        for (i = 1; i<numRows; i++)
            rows.get(0).append(rows.get(i));
        return rows.get(0).toString();
    }

    @Test
    public void Run() {
        String input = "PAYPALISHIRING";
//        String input = "121111";
//        String input = "12345678912345";
        System.out.println(convert(input, 19));
        System.out.println(convert2(input, 2));
    }
}
