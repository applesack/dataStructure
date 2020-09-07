package leetcodes.nums;

import java.util.Stack;

public class P155 {

    class MinStack {

        private Stack<Integer> stact;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stact = new Stack<>();
            minStack = new Stack<>();
        }
        
        public void push(int x) {
            stact.push(x);
            if (minStack.size() != 0) {
                minStack.push(Math.min(minStack.peek(), x));
            } else {
                minStack.push(x);
            }
        }
        
        public void pop() {
            if (stact.isEmpty()) 
                return;

            minStack.pop();
            stact.pop();
        }
        
        public int top() {
            return stact.peek();
        }
        
        public int getMin() {
            return minStack.peek();
        }

    }
    
}
