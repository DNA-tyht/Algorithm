package 中等;

/**
 * @Description 2
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/9 13:20
 */
public class 两数相加 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode res = new ListNode();
        int carry = 0;
        head.next = res;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode();
            node.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            res.next = node;
            res = res.next;
        }
        while (l1 != null) {
            ListNode node = new ListNode();
            node.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            res.next = node;
            res = res.next;
        }
        while (l2 != null) {
            ListNode node = new ListNode();
            node.val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            l2 = l2.next;
            res.next = node;
            res = res.next;
        }
        if (carry == 1) {
            ListNode node = new ListNode();
            node.val = 1;
            res.next = node;
            res = res.next;
        }
        return head.next.next;
    }
}
