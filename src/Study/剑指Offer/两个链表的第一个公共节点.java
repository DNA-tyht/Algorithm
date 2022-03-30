package Study.剑指Offer;

/**
 * @Description 52
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 21:27
 */
public class 两个链表的第一个公共节点 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            lengthA++;
            curA = curA.next;
        }
        while (curB != null) {
            lengthB++;
            curB = curB.next;
        }
        if (lengthA > lengthB)
            return isEqual(headA, headB, lengthA, lengthB);
        else
            return isEqual(headB, headA, lengthB, lengthA);
    }

    private ListNode isEqual(ListNode headA, ListNode headB, int lengthA, int lengthB) {
        int count = 0;
        while (headA != null && count < lengthA - lengthB) {
            headA = headA.next;
            count++;
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
