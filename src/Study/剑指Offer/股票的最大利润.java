package Study.剑指Offer;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/22 14:40
 */
public class 股票的最大利润 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            if (prices[i] - min > max)
                max = prices[i] - min;
        }
        return max;
    }
}
