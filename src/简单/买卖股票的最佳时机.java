package 简单;

/**
 * @Description 121
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/19 20:57
 */
public class 买卖股票的最佳时机 {

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            else if (prices[i] - min > res)
                res = prices[i] - min;
        }
        return res;
    }
}
