package DNA.基础;

import java.util.HashMap;

/**
 * @Description 复制含有随机指针节点的链表
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/18 16:10
 */
public class CopyListWithRand {

    //使用hash表
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) { //复制结点
            map.put(cur, new Node(cur.data));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) { //复制随机指针指向
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    //不使用hash表
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        while (cur != null) { //复制结点
            next = cur.next;
            cur.next = new Node(cur.data);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while (cur != null) { //复制rand指向
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        //拆分链表
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : next;
            cur = next;
        }
        return res;
    }
}
