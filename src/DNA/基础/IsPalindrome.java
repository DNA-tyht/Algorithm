package DNA.基础;

import java.util.Stack;

/**
 * @Description 回文链表
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/18 14:53
 */
public class IsPalindrome {

    //空间复杂度O(N)
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.data != stack.pop().data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //空间复杂度O(N/2)
    public static boolean isPalindrome2(Node head) {
        Stack<Node> stack = new Stack<>();
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next; //慢指针
        Node cur = head; //快指针
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.data != stack.pop().data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //空间复杂度O(1)
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head; //慢指针
        Node n2 = head; //快指针
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next; //n1 -> mid
            n2 = n2.next.next; //n2 -> end
        }
        n2 = n1.next; //n2 -> 右半部第一个结点
        n1.next = null; //中间结点断开连接
        Node n3 = null;
        while (n2 != null) { //右半部分链表逆序
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1; //n3 -> 最后一个结点
        n2 = head; //n2 -> 第一个结点
        while (n1 != null && n2!= null) { //比较两部分结点
            if (n1.data != n2.data) {
                return true;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { //还原链表
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return true;
    }
}
