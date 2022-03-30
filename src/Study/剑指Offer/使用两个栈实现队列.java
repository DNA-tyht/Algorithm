package Study.剑指Offer;

import java.util.Stack;

/**
 * @Description 9
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/16 14:56
 */
public class 使用两个栈实现队列 {

    class CQueue {

        private Stack<Integer> push;
        private Stack<Integer> pop;

        public CQueue() {
            push  = new Stack<>();
            pop = new Stack<>();
        }

        public void appendTail(int value) {
            push.push(value);
        }

        public int deleteHead() {
            if (!pop.isEmpty()) {
                return pop.pop();
            } else {
                while (!push.isEmpty())
                    pop.push(push.pop());
                return pop.isEmpty() ? -1 : pop.pop();
            }
        }
    }
}
