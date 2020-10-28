package leetcodes.ds.util;

import leetcodes.ds.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月27日 9:04
 */
public class NestedIntegerUtil {

    public static NestedInteger getInstance(int ... nums) {
        if (nums == null)
            return getInstance0(0, new ArrayList<>(), false);
        if (nums.length == 1)
            return getInstance0(nums[0], null, true);

        List<NestedInteger> list = new ArrayList<>();
        for (int num : nums) {
            list.add(getInstance(num));
        }
        return getInstance0(0, list, false);
    }

    private static NestedInteger getInstance0(int num, List<NestedInteger> list, boolean isInteger) {
        return new NestedInteger() {
            @Override
            public boolean isInteger() {
                return isInteger;
            }

            @Override
            public Integer getInteger() {
                return isInteger ? num : num;
            }

            @Override
            public List<NestedInteger> getList() {
                return isInteger ? null : list;
            }
        };
    }

    private NestedIntegerUtil() {
    }

}
