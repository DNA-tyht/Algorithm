package DNA.基础;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/19 14:11
 */
public class PreInPosTraversal {

    public static void f(Node head) {
        if (head == null) {
            return;
        }
        //第一次回到f(x)
        f(head.left);
        //第二次回到f(x)
        f(head.rand);
        //第三次回到f(x)
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.data + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.data + " ");
        inOrderRecur(head.right);
    }

    public static void inOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.data + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.data + " ");
    }

    public static void posOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> pos = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                pos.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!pos.isEmpty()) {
                System.out.println(pos.pop().data + " ");
            }
        }
    }

    public static int maxWidthLength(Node head) {
        if (head != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);

            HashMap<Node, Integer> levelMap = new HashMap<>();
            levelMap.put(head, 1);
            int curLevel = 1;
            int curLevelNodes = 0;
            int max = Integer.MIN_VALUE; //结点最多的层结点数

            while (!queue.isEmpty()) {
                head = queue.poll();
                int curNodeLevel = levelMap.get(head);
                //对结点数的统计
                if (curNodeLevel == curLevel) {
                    curLevelNodes++;
                } else { //本层结算，开始下一层
                    max = Math.max(max, curLevelNodes);
                    curLevel++;
                    curLevelNodes = 0;
                }
                if (head.left != null) {
                    levelMap.put(head.left, curNodeLevel + 1);
                    queue.add(head.left);
                }
                if (head.right != null) {
                    levelMap.put(head.right, curNodeLevel + 1);
                    queue.add(head.rand);
                }
            }
            return max;
        }
        return 0;
    }
}
