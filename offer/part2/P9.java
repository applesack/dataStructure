package part2;

import org.junit.Test;
import sun.plugin.javascript.navig.Link;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年08月03日 8:29
 */
public class P9 {

    @Test
    public void testMyStack() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);

        queue.deleteHead();
        queue.deleteHead();

        queue.printAll();
    }

    @Test
    public void testMyQueue() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        stack.pop();
        stack.pop();

        stack.printAll();
    }

    /**
     * 用两个栈实现的队列
     * @param <T>
     */
    private class MyQueue<T> {

        private Stack<T> left;
        private Stack<T> right;

        public MyQueue() {
            left  = new Stack<>();
            right = new Stack<>();
        }

        public void appendTail(T t) {
            left.push(t);
        }

        public T deleteHead() {

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            T value = right.pop();

            while (!right.isEmpty()) {
                left.push(right.pop());
            }

            return value;
        }

        public boolean isEmpty() {
            return left.isEmpty();
        }

        public void printAll() {
            System.out.println(left);
        }
    }

    /**
     * 用两个队列实现的栈
     * @param <T>
     */
    private class MyStack<T> {

        private Queue<T> left;
        private Queue<T> right;

        public MyStack() {
            left = new LinkedList<>();
            right = new LinkedList<>();
        }

        public void push(T t) {
            right.add(t);
        }

        public T pop() {
            while (!right.isEmpty()) {
                if (right.size() == 1)
                    break;
                left.add(right.remove());
            }

            T value = right.remove();

            while (!left.isEmpty()) {
                right.add(left.remove());
            }

            return value;
        }

        public boolean isEmpty() {
            return right.isEmpty();
        }

        public void printAll() {
            System.out.println(right);
        }
    }
}
