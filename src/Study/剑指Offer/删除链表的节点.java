package Study.剑指Offer;

/**
 * @Description 18
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 20:56
 */
public class 删除链表的节点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        ListNode curPre = head, cur = head.next;
        while (cur != null) {
            if (curPre == head && curPre.val == val)
                return head.next;
            if (cur.val == val)
                curPre.next = cur.next;
            curPre = curPre.next;
            cur = cur.next;
        }
        return head;
    }


}
