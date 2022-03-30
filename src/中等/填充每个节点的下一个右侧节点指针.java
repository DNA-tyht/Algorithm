package 中等;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 116
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/26 15:22
 */
public class 填充每个节点的下一个右侧节点指针 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node head) {
        if (head != null) {
            int size = 0;
            Node node = head;
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                node = queue.poll();
                size++;
                if (isTwPower(size + 1))
                    node.next = null;
                else
                    node.next = queue.peek();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return head;
    }

    private static boolean isTwPower(int num) {
        return (num & (num - 1)) == 0;
    }
}
