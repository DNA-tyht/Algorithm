package Study.剑指Offer;

import java.util.Stack;

/**
 * @Description 30
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/16 15:20
 */
public class 包含min函数的栈 {

    class MinStack {

        private Stack<Integer> minStack;
        private Stack<Integer> stack;

        public MinStack() {
            minStack = new Stack<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x)
                minStack.push(x);
        }

        public void pop() {
            if (stack.peek().equals(minStack.peek()))
                minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
