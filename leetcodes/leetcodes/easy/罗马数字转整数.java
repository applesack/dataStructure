package leetcodes.easy;

import leetcodes.util.LeetCodes;

import java.util.HashMap;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月06日 11:49
 */

@LeetCodes(
        id = 13,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/06"
)
public class 罗马数字转整数 {

    public static void main(String[] args) {

        System.out.println(test("IV"));
        System.out.println(test("IX"));
        System.out.println(test("III"));
        System.out.println(test("I"));
        System.out.println(test("LVIII"));
        System.out.println(test("MCMXCIV"));
    }

    public static int test(String str) {

        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i<str.length(); i++) {

            if (i > 0 && map.get(str.charAt(i - 1)) < map.get(str.charAt(i))) {
                result += map.get(str.charAt(i)) - map.get(str.charAt(i - 1))*2;
            } else {
                result += map.get(str.charAt(i));
            }
        }

        return result;
    }
}
