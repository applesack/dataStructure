package offer.part4;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月13日 14:41
 */
public class P30 {

    @Test
    public void testFunc() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(2);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }


    private class MyStack<T extends Comparable<? super T>> {
        private Stack<T> stack;
        private Stack<T> tmpStack;

        public MyStack() {
            stack    = new Stack<T>();
            tmpStack = new Stack<T>();
        }

        public T pop() {
            tmpStack.pop();
            return stack.pop();
        }

        public void push(T type) {
            if (stack.isEmpty()) {
                tmpStack.push(type);
                stack.push(type);

                return;
            }

            T nVal = stack.push(type);
            T oVal = tmpStack.peek();
            tmpStack.push(oVal.compareTo(nVal) > 0 ? nVal : oVal);
        }

        public T min() {
            return tmpStack.peek();
        }
    }
}
