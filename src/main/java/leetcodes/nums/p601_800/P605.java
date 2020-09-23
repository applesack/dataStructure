package leetcodes.nums.p601_800;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月22日 19:29
 */
public class P605 {

    @Test
    public void testFunc() {
        int[] in = {0, 1, 0, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(in, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 || flowerbed.length == 0)
            return true;

        if (flowerbed.length <= 2) {
            if (n == 1) {
                return flowerbed[0] == 0;
            }
            return false;
        }

        int len = flowerbed.length;
        int count = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            count += 1;
            flowerbed[0] = 1;
        }
        int i = flowerbed[0] == 1 ? 2 : 1;

        while (i < len - 1) {
            if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    count += 1;
                } else {
                    i += 1;
                }
            } else {
                i += 2;
            }
        }

        count += flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0 ? 1 : 0 ;

        return count >= n;
    }

}
