package leetcodes.nums.p201_400;

import org.junit.Test;

import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月14日 10:01
 */
public class P232 {

    @Test
    public void testClazz() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }

    private class MyQueue {
        Stack<Integer> left;
        Stack<Integer> right;

        /** Initialize your data structure here. */
        public MyQueue() {
            left = new Stack<>();
            right = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            left.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            int res = right.pop();
            while (!right.isEmpty()) {
                left.push(right.pop());
            }
            return res;
        }

        /** Get the front element. */
        public int peek() {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            int res = right.peek();
            while (!right.isEmpty()) {
                left.push(right.pop());
            }
            return res;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return left.isEmpty();
        }
    }

}
