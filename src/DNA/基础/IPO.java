package DNA.基础;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/25 12:04
 */
public class IPO {

    public static class Node {
        public int cost;
        public int profit;

        public Node(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost - o2.cost;
        }
    }
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit - o1.profit;
        }
    }

    public static int findMaximizedCosts(int k, int w, int[] profits, int[] costs) {
        PriorityQueue<Node> minCost = new PriorityQueue(new MinCostComparator());
        PriorityQueue<Node> maxProfit = new PriorityQueue(new MaxProfitComparator());
        for (int i = 0; i < profits.length; i++) { //花费从小到大排列
            minCost.add(new Node(profits[i], costs[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minCost.isEmpty() && minCost.peek().cost <= w) {
                maxProfit.add(minCost.poll()); //解锁所有能做的项目
            }
            if (maxProfit.isEmpty()) {
                return w;
            }
            w += maxProfit.poll().profit;
        }
        return w;
    }
}
