package nums;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月25日 9:02
 */
public class P17 {

    @Test
    public void testFunc() {
        String input = "234";
        System.out.println(letterCombinations(input));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null)
            return new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> charList = new ArrayList<>();
        String tmp;
        for (int i = 0; i<digits.length(); i++) {
            tmp = map.get(digits.charAt(i));
            if (tmp != null)
                charList.add(tmp);
        }

        return fullArray(charList, 0, new ArrayList<>(), new StringBuffer());
    }

    public List<String> fullArray(List<String> charList, int curIdx,
                                  List<String> res, StringBuffer sb) {
        if (curIdx == charList.size()) {
            return res;
        }

        String chars = charList.get(curIdx);
        for (int i = 0; i<chars.length(); i++) {
            if (curIdx == charList.size() - 1) {
                sb.append(chars.charAt(i));
                res.add(sb.toString());
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(chars.charAt(i));
                fullArray(charList, curIdx + 1, res, sb);
            }
        }

        if (sb.length() >= 1)
            sb.setLength(sb.length() - 1);
        return res;
    }
}
