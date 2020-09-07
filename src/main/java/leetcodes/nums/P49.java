package leetcodes.nums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P49 {
    
    private static final P49 solution = new P49();

    public static void main(String[] args) {
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<int[]> intList = new ArrayList<>();
        int[] tmpIntArr;
        for (String str : strs) {
            tmpIntArr = new int[str.length()];
            for (int i = 0; i<str.length(); i++) {
                tmpIntArr[i] = str.charAt(i);
            }
            Arrays.sort(tmpIntArr);
            intList.add(tmpIntArr);
        }

        List<List<String>> res = new ArrayList<>();
        List<String> tmpRes;
        int[] values, tmpValues;
        for (int o = 0; o<strs.length; o++) {
            if (intList.get(o) == null)
                continue; 

            tmpRes = new ArrayList<>();
            tmpRes.add(strs[o]);
            values = intList.get(o);
            boolean isSans;
            for (int i = 0; i<intList.size(); i++) {
                if (o == i || intList.get(i) == null 
                    || intList.get(i).length != values.length)
                    continue;

                isSans = true;
                tmpValues = intList.get(i);
                for (int j = 0; j < tmpValues.length; j++) {
                    if (tmpValues[j] != values[j]) {
                        isSans = false;
                        break;
                    }
                }

                if (isSans) {
                    intList.set(i, null);
                    tmpRes.add(strs[i]);
                }
            }

            res.add(tmpRes);
        }

        return res;
    }

}
