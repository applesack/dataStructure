package zleetcodes.util;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年06月25日 21:06
 */
public class 统计中文个数 {

    public static void main(String[] args) {
        String str = "一2121二121221三四";
        for (int i = 0; i<str.length(); i++) {
            long c = (long) str.charAt(i);
            if (c >= 0x4E00 && c <= 0x9FFF)
                System.out.println(str.charAt(i));
        }
    }
}
