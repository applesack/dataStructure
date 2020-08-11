package zleetcodes.medium;

import zleetcodes.util.LeetCodes;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月21日 10:06
 */

@LeetCodes(
        id = 8,
        level = LeetCodes.LEVEL.MEDIUM,
        status = LeetCodes.Status.UN_START,
        tags = {"字符串"},
        createDate = "2020/05/21",
        finishTime = "1h"
)
public class 字符串转换整数atoi {

    public static int myAtoi(String str) {
        int index = -1;

        // 找到最开始的有效位数
        for (int i = 0; i< str.length(); i++) {
            if ((str.charAt(i) == '+' || str.charAt(i) == '-') ||
                    str.charAt(i) >= '0' && str.charAt(i) < '9') {
                index = i;
                break;
            }
        }

        if (index == -1 || index == str.length()-1) return 0;

        for (int i = index; i<str.length(); i++) {

        }

        return 0;
    }
}
