package util;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月10日 16:26
 */
public class RandomUtil {

    // 随机数的默认值，取一个较大的区间
    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 1000000;

    /**
     * 使用默认的参数创建一个随机的数组
     * @param len 数组的长度
     * @return 由随机数构成的数组
     */
    public static int[] getRandomArr(int len) {
        return getRandomArr(DEFAULT_MIN, DEFAULT_MAX, len);
    }

    /**
     * 生成随机数数组
     * @param min 生成随机数的最小值
     * @param max 生成随机数的最大值
     * @param len 数组的长度
     * @return 有随机数构成的数组
     */
    public static int[] getRandomArr(int min, int max, int len) {
        int[] res_arr = new int[len];
        for (int i = 0; i<res_arr.length; i++) {
            res_arr[i] = getRandomInt(min, max);
        }
        return res_arr;
    }

    /**
     * 获取一个随机数
     * @param min 生成随机数的最小值
     * @param max 生成随机数的最大值
     * @return
     */
    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    private RandomUtil() {}
}
