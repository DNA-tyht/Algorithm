package 中等;

import java.util.HashMap;
import java.util.Random;

/**
 * @Description 382
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 20:31
 */
public class 链表随机节点 {
    class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        private int length;
        private HashMap<Integer, Integer> map = new HashMap<>();
        public Solution(ListNode head) {
            length = 0;
            while (head != null) {
                map.put(length++, head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            Random ran = new Random();
            int random = ran.nextInt(length);
            return map.get(random);
        }
    }
}
