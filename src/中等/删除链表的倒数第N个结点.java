package 中等;

import 简单.链表的中间结点;

/**
 * @Description 19
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/26 12:46
 */
public class 删除链表的倒数第N个结点 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode high = head, low = node;
        for (int i = 0; i < n; i++)
            high = high.next;
        while (high != null) {
            high = high.next;
            low = low.next;
        }
        low.next = low.next.next;
        return node.next;
    }
}
