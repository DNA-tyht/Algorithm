package DNA.基础;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/25 11:34
 */
public class LessMoneySplitGold {

    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2; //o1 < o2 为复数
        }
    }

    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (queue.size() > 1) {
            cur = queue.poll() + queue.poll();
            sum += cur;
            queue.add(cur);
        }
        return sum;
    }
}
