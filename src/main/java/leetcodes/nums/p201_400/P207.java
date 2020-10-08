package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月08日 8:57
 */
public class P207 {

    @Test
    public void testFunc() {
        int[][] input = {
                {1, 0},{0,1}
        };
        System.out.println(canFinish(2, input));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, Set<Integer>> requiredMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            int value = prerequisite[1];
            Set<Integer> set = requiredMap.computeIfAbsent(key, k -> new HashSet<>());
            set.add(value);
        }

        Deque<Integer> path = new LinkedList<>();
        for (int i = 0; i<prerequisites.length; i++) {
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];
            Set<Integer> set = requiredMap.get(key);
            if (set != null && !set.isEmpty()) {
                for (Integer clue : set) {

                }
            }
        }

        return true;
    }

}
