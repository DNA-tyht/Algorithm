package Study.剑指Offer;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 12:01
 */
public class 反转链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode left = null;
        ListNode mid = head;
        ListNode right = head.next;
        while (right != null) {
            mid.next = left;
            left = mid;
            mid = right;
            right = right.next;
        }
        mid.next = left;
        return mid;
    }
}
