package Study.剑指Offer;

import java.util.HashMap;

/**
 * @Description 35
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 18:49
 */
public class 复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> copyMap = new HashMap<>();
        Node node = head;
        while (node != null) { //复制结点
            copyMap.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while (node != null) { //复制指向
            copyMap.get(node).next = copyMap.get(node.next);
            copyMap.get(node).random = copyMap.get(node.random);
            node = node.next;
        }
        return copyMap.get(head);
    }
}
