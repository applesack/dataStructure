package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.*;

/**
 * @author : flutterdash@qq.com
 * @since : 2020年10月09日 9:21
 */
public class P227 {

    @Test
    public void testFunc() {
        String expression = "1-1+1";
        System.out.println(calculate(expression));
    }

    private final StringBuilder sb = new StringBuilder();
    private int num1, num2;
    private static final HashMap<Character, Integer> OPERATOR_PRIORITY = new HashMap<>();
    static {
        OPERATOR_PRIORITY.put('+', 1);
        OPERATOR_PRIORITY.put('-', 1);
        OPERATOR_PRIORITY.put('*', 2);
        OPERATOR_PRIORITY.put('/', 2);
    }

    public int calculate(String s) {
        int defaultVal = 0;
        if (s == null || s.length() == 0)
            return defaultVal;

        List<String> postfix = infix2postfix(s);
        return doPostfix(postfix);
    }

    // 中缀表达式转后缀表达式
    private List<String> infix2postfix(String infixStr) {
        // 将字符串转换成中缀表达式列表
        List<String> infix = new ArrayList<>();
        char[] infixArr = infixStr.toCharArray();
        sb.setLength(0);
        for (char c : infixArr) {
            if (c == ' ')
                continue;
            if (OPERATOR_PRIORITY.containsKey(c)) { // 是操作符
                infix.add(sb.toString());
                sb.setLength(0);
            } else { // 是数字
                if (sb.length() > 0 && OPERATOR_PRIORITY.containsKey(sb.charAt(0))) {
                    infix.add(sb.toString());
                    sb.setLength(0);
                }
            }
            sb.append(c);
        }

        if (sb.length() > 0) {
            infix.add(sb.toString());
            sb.setLength(0);
        }

        // 将中缀表达式转换为后缀表达式

        Stack<String> rStack = new Stack<>();    // 存放结果的栈
        Stack<Character> oStack = new Stack<>(); // 临时存放操作符的栈

        for (String item : infix) {
            if (item.length() == 1 && OPERATOR_PRIORITY.containsKey(item.charAt(0))) { // 是操作符
                int curValue = OPERATOR_PRIORITY.get(item.charAt(0));
                // 进入操作符栈之前，先将操作符栈中优先级较高的操作符弹出到结果栈
                while (!oStack.isEmpty() && OPERATOR_PRIORITY.get(oStack.peek()) >= curValue) {
                    rStack.push(String.valueOf(oStack.pop()));
                }
                oStack.push(item.charAt(0));
            } else {
                rStack.push(item);
            }
        }

        while (!oStack.isEmpty()) {
            rStack.push(String.valueOf(oStack.pop()));
        }

        LinkedList<String> postfix = new LinkedList<>();
        while (!rStack.isEmpty()) {
            postfix.addFirst(rStack.pop());
        }

        return postfix;
    }

    // 计算后缀表达式
    private int doPostfix(List<String> postfix) {
        Stack<Integer> numbers = new Stack<>();
        for (String curItem : postfix) {
            if (curItem.length() == 1 && OPERATOR_PRIORITY.containsKey(curItem.charAt(0))) {

                char operation = curItem.charAt(0);
                num2 = numbers.pop();
                num1 = numbers.pop();
                switch (operation) {
                    case '+':
                        numbers.push(invoke(Integer::sum));
                        break;
                    case '-':
                        numbers.push(invoke((n1, n2) -> n1 - n2));
                        break;
                    case '*':
                        numbers.push(invoke((n1, n2) -> n1 * n2));
                        break;
                    case '/':
                        numbers.push(invoke((n1, n2) -> n1 / n2));
                        break;
                }

            } else {
                numbers.push(Integer.valueOf(curItem));
            }
        }
        return numbers.pop();
    }

    private int invoke(Operating operating) {
        return operating.calculate(num1, num2);
    }

    interface Operating {
        int calculate(int num1, int num2);
    }
}
