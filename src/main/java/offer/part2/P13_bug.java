package offer.part2;

import org.junit.Test;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月03日 16:32
 */
public class P13_bug {

    @Test
    public void testFunc() {
        int input = 18;

        System.out.println(moveCount(input));
    }

    /**
     * 在满足条件的情况下，能覆盖到多少个格子
     * 默认起始坐标从 (0, 0) 开始
     * @param k 横坐标和纵坐标的位置和总数的上限
     * @return
     */
    private int moveCount(int k) {

        return moveCountCore(0, 0, new HashMap<Integer, Set<Integer>>(), k);
    }

    private int moveCountCore(int x, int y, Map<Integer, Set<Integer>> map, int k) {

        int sum = 0;

        // 上
        if (!isOutOfBounds(x, y, k) && (!map.containsKey(x) || !map.get(x).contains(y+1))) {
            if (map.get(x) == null) {
                Set set = new HashSet();
                set.add(y+1);
                map.put(x, set);
            } else {
                map.get(x).add(y+1);
            }
            sum += moveCountCore(x, y+1, map, k);
        }

        // 右
        if (!isOutOfBounds(x, y, k) && (!map.containsKey(x+1) || !map.get(x+1).contains(y))) {
            if (!map.containsKey(x+1)) {
                Set set = new HashSet();
                set.add(y);
                map.put(x+1, set);
            } else {
                map.get(x+1).add(y);
            }
            sum += moveCountCore(x+1, y, map, k);
        }

        // 下
        if (!isOutOfBounds(x, y, k) && (y-1 >= 0 && !map.containsKey(x) || !map.get(x).contains(y-1))) {
            if (!map.containsKey(x)) {
                Set set = new HashSet();
                set.add(y-1);
                map.put(x, set);
            } else {
                map.get(x).add(y-1);
            }
            sum += moveCountCore(x, y-1, map, k);
        }

        // 左
        if (!isOutOfBounds(x, y, k) && x-1>=0 && (!map.containsKey(x-1) || map.get(x-1).contains(y))) {
            if (!map.containsKey(x-1)) {
                Set set = new HashSet();
                set.add(y);
                map.put(x-1, set);
            } else {
                map.get(x-1).add(y);
            }
            sum += moveCountCore(x-1, y, map, k);
        }

        return sum;
    }

    /**
     * 检查的规则是判断x和y的位的和是否超过目标值
     * 例如 x=35, y=38, 则每个位的总和为 3+5+3+8 = 38
     * 和目标值相同，没有超越目标值，所以返回是false
     *
     * @param x
     * @param y
     * @param boundary
     * @return 有没有越界
     */
    private boolean isOutOfBounds(int x, int y, int boundary) {
        int x_val = 0;
        int y_val = 0;

        while (x != 0) {
            x_val += x % 10;
            x /= 10;
        }

        while (y != 0) {
            y_val += y % 10;
            y /= 10;
        }

        return (x_val + y_val) > boundary;
    }

    @Test
    public void testCheckFunc() {
        System.out.println(isOutOfBounds(35, 37, 18));
    }
}
