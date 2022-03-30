package 简单;

/**
 * @Description 876
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/26 12:28
 */
public class 链表的中间结点 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public static ListNode middleNode(ListNode head) {
         ListNode high = head, low = head;
         while (high != null && high.next != null) {
             high = high.next.next;
             low = low.next;
         }
         return low;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
