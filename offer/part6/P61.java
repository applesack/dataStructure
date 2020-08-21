package part6;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月21日 14:12
 */
public class P61 {

    @Test
    public void testFunc() {
        int[] pokers = {0,1,4,7,0,6};
        System.out.println(isContinuous(pokers));
    }

    // 判断所给的扑克是否可以组成顺子，大王和小王可以看成任意数字牌
    // 除大王小王外，有重复的牌，则这副牌里有对子，不可能是顺子
    // A=1 J=11 Q=12 K=13
    private boolean isContinuous(int[] pokers) {
        if (pokers == null || pokers.length <= 5)
            return false;

        Arrays.sort(pokers);

        int countZero = 0;
        for (int i = 0; i<pokers.length; i++) {
            if (pokers[i] == 0)
                countZero++;
        }

        int diff = 0;
        for (int i = countZero; i<pokers.length; i++) {
            if (pokers[i] == pokers[i - 1])
                return false;
            diff += pokers[i] - pokers[i - 1] - 1;
        }

        return countZero >= diff;
    }
}
