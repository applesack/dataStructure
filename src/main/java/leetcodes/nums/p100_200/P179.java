package leetcodes.nums.p100_200;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月22日 21:08
 */
public class P179 {

    @Test
    public void testFunc() {
        int[] in =
//                {3, 30, 34, 5, 9};
//                {12, 121};
                {90, 91, 9};
        System.out.println(largestNumber(in));
    }

    public String largestNumber(int[] nums) {

        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            LinkedList<Integer> inner = new LinkedList<>();
            while (num > 0) {
                inner.addFirst(num % 10);
                num /= 10;
            }
            list.add(inner);
        }

        list.sort((a, b) -> {
            Iterator<Integer> aIter = a.listIterator();
            Iterator<Integer> bIter = b.listIterator();
            while (aIter.hasNext() || bIter.hasNext()) {
                int aVal = aIter.hasNext() ? aIter.next() : 0,
                    bVal = bIter.hasNext() ? bIter.next() : 0;
                if (aVal > bVal) return a.size() > b.size() ? 1 : -1;
                if (aVal < bVal) return a.size() > b.size() ? -1 : 1;
            }
            return a.size() - b.size();
        });

        StringBuilder sb = new StringBuilder();
        for (List<Integer> ls : list) {
            for (Integer integer : ls) {
                sb.append(integer);
            }
            sb.append(", ");
        }
        return sb.toString();
    }

}
