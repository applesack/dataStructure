package leetcodes.nums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月10日 17:34
 */
public class P165 {

    @Test
    public void testFunc() {
        String version1 = "1";
        String version2 = "0";
        System.out.println(compareVersion(version1, version2));
    }

    public int compareVersion(String version1, String version2) {

        StringBuffer tmp = new StringBuffer();
        List<Integer> ver1 = getVersionValue(version1, tmp);
        List<Integer> ver2 = getVersionValue(version2, tmp);

        int min = Math.min(ver1.size(), ver2.size());
        for (int i = 0; i<min; i++) {
            if (ver1.get(i) > ver2.get(i)) {
                return 1;
            } else if (ver1.get(i) < ver2.get(i)) {
                return -1;
            }
        }

        if (ver1.size() == ver2.size())
            return 0;
        if (ver1.size() > ver2.size()) {
            return 1;
        } else
            return -1;
    }

    private List<Integer> getVersionValue(String version, StringBuffer tmp) {
        tmp.setLength(0);
        char[] chars = version.toCharArray();
        ArrayList<Integer> res = new ArrayList<>();
        for (char c : chars) {
            if (c == '.') {
                res.add(Integer.parseInt(tmp.toString()));
                tmp.setLength(0);
            } else {
                tmp.append(c);
            }
        }

        res.add(Integer.parseInt(tmp.toString()));
        int idx = res.size() - 1;
        while (idx >= 0 && res.get(idx) == 0) {
            res.remove(idx--);
        }

        return res;
    }

}
