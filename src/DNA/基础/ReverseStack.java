package DNA.基础;

import java.util.Stack;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/27 14:58
 */
public class ReverseStack {

    //逆转栈
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = stackEnd(stack);
        //递归栈可以保存信息，进入下层递归
        reverse(stack);
        //回到上层递归，可以获得上层的信息
        stack.push(i);
    }

    //取出栈底
    public static int stackEnd(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = stackEnd(stack);
            stack.push(result);
            return last;
        }
    }
}
