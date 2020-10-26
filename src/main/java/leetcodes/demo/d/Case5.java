package leetcodes.demo.d;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月25日 20:21
 */
public class Case5 {

    @Test
    public void testFunc() {
        System.out.println(getNumOfRGB(0, 255, 255));
        System.out.println(getNumOfRGB0(0, 255, 255));
    }

    public int getNumOfRGB(int r, int g, int b) {
        return getNumOfRGB(new int[] {r, g, b});
    }

    // 23[r, g, b]0
    private int getNumOfRGB(int[] rgb) {
        int sum = 0;
        int base = 16;
        int count;
        for (int color : rgb) {
            count = 0;
            while (color != 0) {
                sum += (color % 2) << (base + count++);
                color >>= 1;
            }
            base -= 8;
        }
        return sum;
    }

    public int getNumOfRGB0(int r, int g, int b) {
        int[] arr = new int[24];
        for (int i = 7; i>=0; i--) {
            arr[i] = r % 2;
            r /= 2;
        }
        for (int i = 15; i>=8; i--) {
            arr[i] = g % 2;
            g /= 2;
        }
        for (int i = 23; i>=16; i--) {
            arr[i] = b % 2;
            b /= 2;
        }

        int res = 0;
        for (int i = 23; i>=0; i--)
            res += arr[i] << (23 - i);

        return res;
    }

}
