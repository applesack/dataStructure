package zleetcodes.easy;

import zleetcodes.util.LeetCodes;
import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年04月08日 11:08
 */

@LeetCodes(
        id = 69,
        status = LeetCodes.Status.FINISHED,
        createDate = "2020/04/08"
)
public class x的平方根 {

    public static void main(String[] args) {

    }

    public static int sqrt(int x) {

        return (int) Math.pow(x, 0.5);
    }

    @Test
    public void Run() {
        System.out.println(sqrt(4));
    }
}
