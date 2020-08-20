package myImpl.dataStructrue;

import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月20日 20:59
 */
public class SetTest {

    @Test
    public void testFunc() {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(1);
        input.add(2);
        input.add(2);
        System.out.println(Deduplication(input));
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
