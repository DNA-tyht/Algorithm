package DNA.基础;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/19 12:39
 */
public class FindFirstIntersectNode {

    public static Node findFirstIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    //找到链表的第一个入环结点
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next;
            n1 = n1.next;
        }
        n1 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //如果两个链表都无环，返回第一个相交节点
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        //求出链表长度差值
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null; //两链表不相交
        }
        cur1 = n > 0 ? head1 : head2; //长链表的头给cur1
        cur2 = n > 0 ? head2 : head1; //短链表的头给cur2
        n = Math.abs(n);
        while (n != 0) { //长链表先走差值步
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) { //长短链表同时走，下一次相遇即相交结点
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //如果两个链表都有环，返回第一个相交结点
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            //操作类似无环相交链表
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2; //长链表的头给cur1
            cur2 = n > 0 ? head2 : head1; //短链表的头给cur2
            n = Math.abs(n);
            while (n != 0) { //长链表先走差值步
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) { //长短链表同时走，下一次相遇即相交结点
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
