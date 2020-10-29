package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月28日 15:53
 */
public class P380 {

    @Test
    public void testFunc() {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(-1));
        System.out.println(set.remove(-2));
        System.out.println(set.insert(-2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(-1));
        System.out.println(set.insert(-2));
        System.out.println(set.getRandom());
    }

    static class RandomizedSet {

        private final float loadFactor;        // 装填因子
        private int size;                      // 元素个数

        private int capacity;                  // 容量 -> 数组中已被映射的位置的个数
        private LinkedList<Integer>[] table;   // 散列数组

        /** Initialize your data structure here. */
        public RandomizedSet() {
            loadFactor = 0.75f; // 当数组中已被映射的位置占数组的总容量则调用resize()方法
            size = 0;
            capacity = 0;

            @SuppressWarnings({"rawtypes","unchecked"})
            LinkedList<Integer>[] tmp = (LinkedList<Integer>[]) new LinkedList[8];
            table = tmp;
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            int hash = hash(val);
            LinkedList<Integer> list = table[hash];
            if (list == null) {
                capacity += 1;
                list = new LinkedList<>();
                list.add(val);
                table[hash] = list;
            } else {
                for (Integer integer : list) {
                    if (integer.equals(val))
                        return false;
                }
                list.add(val);
            }
            size += 1;
            resize();
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            int hash = hash(val);
            LinkedList<Integer> list = table[hash];
            if (list == null)
                return false;
            Iterator<Integer> itr = list.iterator();
            while (itr.hasNext()) {
                if (itr.next().equals(val)) {
                    itr.remove();
                    if (list.isEmpty())
                        capacity -= 1;
                    size--;
                    return true;
                }
            }
            return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            List<Integer> notNullIdxList = new ArrayList<>();
            for (int i = 0; i<table.length; i++) {
                if (table[i] != null && !table[i].isEmpty())
                    notNullIdxList.add(i);
            }
            int tableIdx = (int) (Math.random() * notNullIdxList.size());
            LinkedList<Integer> rList = table[notNullIdxList.get(tableIdx)];
            int listIdx = (int) (Math.random() * rList.size());
            return rList.get(listIdx);
        }

        /*****************自定义函数******************/
        private void resize() {
            float current_capacity = capacity / ((float) table.length);
            if (current_capacity < loadFactor)
                return;
            int newSize = table.length * 2;
            @SuppressWarnings({"rawtypes","unchecked"})
            LinkedList<Integer>[] newTab = (LinkedList<Integer>[]) new LinkedList[newSize];
            for (LinkedList<Integer> list : table) {
                if (list == null || list.isEmpty())
                    continue;
                int hashCode = hash(list.get(0), newSize);
                newTab[hashCode] = list;
            }
            table = newTab;
        }

        private int hash(int val) {
            return hash(val, table.length);
        }

        private int hash(int val, int n_size) {
            return Math.abs(val) % n_size;
        }

        public int size() {
            return size;
        }
    }

}
