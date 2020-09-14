package leetcodes.nums;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月14日 10:39
 */
public class P225 {

    @Test
    public void testClazz() {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    class MyStack {

        Queue<Integer> queue;
        Queue<Integer> tmp;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new ArrayDeque<>();
            tmp = new ArrayDeque<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while (queue.size() > 1) {
                tmp.add(queue.remove());
            }
            int res = queue.remove();
            while (!tmp.isEmpty()) {
                queue.add(tmp.remove());
            }
            return res;
        }

        /** Get the top element. */
        public int top() {
            while (queue.size() > 1) {
                tmp.add(queue.remove());
            }
            int res = queue.peek();
            tmp.add(queue.remove());
            while (!tmp.isEmpty()) {
                queue.add(tmp.remove());
            }
            return res;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
