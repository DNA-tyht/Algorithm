package 简单;

/**
 * @Description 746
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/18 12:11
 */
public class 使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1]; //到达小标i的最小花费
        //n个阶梯对应n-1，n个阶梯顶部对应n
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
