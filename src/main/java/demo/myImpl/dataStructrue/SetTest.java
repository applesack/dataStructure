package demo.myImpl.dataStructrue;

import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月20日 20:59
 */
public class SetTest {

    @Test
    public void testFunc() {
        sort(3, 1, 2);
    }

    public void sort(int num1, int num2, int num3) {
        int min, mid = -1, max;
        max = Math.max(Math.max(num1, num2), Math.max(num2, num3));
        min = Math.min(Math.min(num1, num2), Math.min(num2, num3));
        int[] data = {min, -1, max};
        if (num1 != min && num1 != max)
            mid = num1;
        if (num2 != min && num2 != max)
            mid = num2;
        if (num3 != min && num3 != max)
            mid = num3;
        data[1] = mid;
        System.out.println(Arrays.toString(data));
    }

    public <E extends Comparable<E>> List<E> Deduplication(Collection<E> collection) {
        Iterator<E> iterator = collection.iterator();
        Set<E> set = new LinkedHashSet<>();
        List<E> resList = new ArrayList<>();

        E tmp;
        while (iterator.hasNext()) {
            tmp = iterator.next();
            if (set.contains(tmp))
                continue;
            resList.add(tmp);
            set.add(tmp);
        }

        return resList;
    }
}
