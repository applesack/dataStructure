package leetcodes.nums.p401_600;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年11月05日 19:15
 */
public class P412 {

    @Test
    public void testFunc() {
        System.out.println(fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        final String odd3 = "Fizz";
        final String odd5 = "Buzz";
        List<String> ans = new ArrayList<>(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=n; i++) {
            sb.setLength(0);
            if (i % 3 == 0)
                sb.append(odd3);
            if (i % 5 == 0)
                sb.append(odd5);
            if (sb.length() == 0)
                sb.append(i);
            ans.add(sb.toString());
        }
        return ans;
    }

}
