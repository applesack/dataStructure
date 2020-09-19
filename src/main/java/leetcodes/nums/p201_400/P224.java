package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月13日 10:16
 */
public class P224 {

    @Test
    public void testFunc() {
        String in = "2-1+2";
        System.out.println(calculate(in));
    }

    StringBuffer sb = new StringBuffer();

    public int calculate(String s) {
        // 记录运算优先级
        Map<String, Integer> map = new HashMap<>();
        map.put("+", 1);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 2);

        List<String> list = str2list(s);
        List<String> postfix = list2postfix(list, map);
        return getRes(postfix, map);
    }

    // 将字符串处理成数据项的列表
    private List<String> str2list(String oStr) {
        sb.setLength(0);

        char curVal;
        List<String> res = new ArrayList<>();
        for (int i = 0; i<oStr.length(); i++) {
            curVal = oStr.charAt(i);
            if (curVal == ' ')
                continue;
            if (Character.isDigit(curVal)) {
                sb.append(curVal);
            } else {
                if (sb.length() > 0) {
                    res.add(sb.toString());
                    sb.setLength(0);
                }
                res.add(String.valueOf(curVal));
            }
        }

        if (sb.length() > 0)
            res.add(sb.toString());
        return res;
    }

    // 将数据项的列表处理成后缀表达式
    private List<String> list2postfix(List<String> list, Map<String, Integer> wightMap) {
        Stack<String> res = new Stack<>();
        Stack<String> tmp = new Stack<>();

        String curVal;
        for (String s : list) {
            curVal = s;
            if (curVal.equals("(")) {
                tmp.push(curVal);
            } else if (curVal.equals(")")) {
                while (!tmp.peek().equals("(")) {
                    res.push(tmp.pop());
                }
                tmp.pop();
            } else if (!wightMap.containsKey(curVal)) {
                res.push(curVal);
            } else {
                // 假如当前的数据项是操作符，则进入临时栈
                // 进入临时栈之前，将优先级大于当前操作符的操作符推入结果栈
                while (!tmp.isEmpty() && !tmp.peek().equals("(") &&
                        wightMap.get(curVal) <= wightMap.get(tmp.peek())) {
                    res.push(tmp.pop());
                }
                tmp.push(curVal);
            }
        }

        while (!tmp.isEmpty())
            res.push(tmp.pop());

        return new ArrayList<>(res);
    }

    // 计算后缀表达式
    private int getRes(List<String> postfix, Map<String, Integer> map) {
        Stack<Integer> res = new Stack<>();
        int num1, num2;
        String curVar;
        for (int i = 0; i< postfix.size(); i++) {

            curVar = postfix.get(i);

            if (map.containsKey(curVar)) {

                num2 = res.pop();
                num1 = res.pop();

                if (curVar.equals("+")) {
                    res.push(num1 + num2);
                } else if (curVar.equals("-")){
                    res.push(num1 - num2);
                }  else if (curVar.equals("*")) {
                    res.push(num1 * num2);
                } else {
                    res.push(num1 / num2);
                }

            } else {
                res.push(Integer.parseInt(curVar));
            }

        }

        return res.pop();
    }
}
