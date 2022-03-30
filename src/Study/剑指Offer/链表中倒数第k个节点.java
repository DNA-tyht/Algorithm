package Study.剑指Offer;

/**
 * @Description 22
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 21:04
 */
public class 链表中倒数第k个节点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        int num = length - k;
        cur = head;
        for (int i = 0; i < num; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
