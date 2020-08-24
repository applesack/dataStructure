package nums;

import org.junit.Test;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月24日 19:31
 */
public class P20 {

    @Test
    public void testFunc() {
        String input_1 = "()";
        String input_2 = "()[]{}";
        String input_3 = "(]";
        String input_4 = "([)]";
        String input_5 = "{[]}";
        System.out.println(isValid(input_1));
        System.out.println(isValid(input_2));
        System.out.println(isValid(input_3));
        System.out.println(isValid(input_4));
        System.out.println(isValid(input_5));
    }

    public boolean isValid(String s) {
        if (s == null || s.equals(""))
            return true;
        if (s.length() < 2 || s.length() % 2 != 0)
            return false;

        char[][] values = {
                {'(', '[', '{'},
                {')', ']', '}'}
        };

        // 用数组模拟栈
        char[] brackets = new char[s.length() / 2];
        int stackTop = 0;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (isLeftBracket(c, values)) {
                if (stackTop == brackets.length)
                    return false;
                brackets[stackTop] = c;
                stackTop++;
            } else {
                if (stackTop == 0)
                    return false;
                if (isMatch(brackets[stackTop - 1], c, values)) {
                    stackTop--;
                } else {
                    return false;
                }
            }
        }

        return stackTop == 0;
    }

    public boolean isLeftBracket(char bracket, char[][] values) {
        for (int i = 0; i<values[0].length; i++) {
            if (bracket == values[0][i])
                return true;
        }
        return false;
    }

    public boolean isMatch(char lBracket, char rBracket, char[][] values) {
        int l_bracket_idx = 0;
        for (int i = 0; i<values[0].length; i++) {
            if (lBracket == values[0][i]) {
                l_bracket_idx = i;
                break;
            }
        }

        return values[1][l_bracket_idx] == rBracket;
    }
}
