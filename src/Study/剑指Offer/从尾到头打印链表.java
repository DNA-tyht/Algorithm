package Study.剑指Offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description 6
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 11:32
 */
public class 从尾到头打印链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        int index = 0;
        ListNode node = head;
        while (node != null) {
            index++;
            node = node.next;
        }
        int[] arr = new int[index];
        index = 0;
        while (head != null) {
            arr[index++] = head.val;
            head = head.next;
        }
        reverse(arr, 0, arr.length - 1);
        return arr;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
