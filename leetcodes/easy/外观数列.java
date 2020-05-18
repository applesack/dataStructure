package easy;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年05月17日 15:56
 */
public class 外观数列 {

    private static String[] result;

    public static void main(String[] args) {

    }

    private static String test(int n) {
        StringBuffer str = new StringBuffer("1");
        StringBuffer temp = new StringBuffer();
        int count;
        while (n > 1) {
            str.append('#');
            count = 1;
            for (int i = 0; i<str.length()-1; i++) {
                if (str.charAt(i) == str.charAt(i+1)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(str.charAt(i));
                    count = 1;
                }
            }
            str = temp;
            temp = new StringBuffer();
            n--;
        }
        return str.toString();
    }

    @Test
    public void Test() {
        System.out.println(test(2));
    }
}
