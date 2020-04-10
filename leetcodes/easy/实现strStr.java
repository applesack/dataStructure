package easy;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月05日 21:28
 */
public class 实现strStr {

    public static void main(String[] args) {

        System.out.println(test("hello", "ll"));
        System.out.println(test("aaaaa", "bba"));
        System.out.println(test("aa", "bba"));
        System.out.println(test("aaaaa", ""));
    }

    public static int test(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;
        else if (haystack==null || needle == null || haystack.length() < needle.length())
            return -1;

        for (int i = 0; i<haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) &&
                    haystack.length()-i >= needle.length()) {
                boolean flag = true;
                for (int j=1; j<needle.length(); j++) {
                    if (haystack.charAt(i+j)!=needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                    if (flag)
                        return i;
                }
            }
        }

        return -1;
    }
}
