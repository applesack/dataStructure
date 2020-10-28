package leetcodes.nums.p201_400;

import leetcodes.ds.NestedInteger;
import static leetcodes.ds.util.NestedIntegerUtil.*;
import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月27日 9:25
 */
public class P341 {

    @Test
    public void testFunc() {
        List<NestedInteger> list = new ArrayList<>();

//        list.add(getInstance(1, 2, 3, 4));
//        list.add(getInstance(5, 6, 7, 8));
        list.add(getInstance(1));

        Iterator<Integer> itr = new NestedIterator(list);

        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
    }

    public static class NestedIterator implements Iterator<Integer> {

        Deque<NestedInteger> deque = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger nest : nestedList) {
                deque.addLast(nest);
            }
        }

        @Override
        public Integer next() {
            getNext0();
            return deque.removeFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            getNext0();
            return !deque.isEmpty();
        }

        private void getNext0() {
            if (deque.size() == 0)
                return;
            NestedInteger nested = deque.peekFirst();
            while (nested != null && !nested.isInteger()) {
                deque.removeFirst();
                List<NestedInteger> list = nested.getList();
                for (int i = list.size() - 1; i>=0; i--) {
                    deque.addFirst(list.get(i));
                }
                nested = deque.peekFirst();
            }
        }
    }

}
