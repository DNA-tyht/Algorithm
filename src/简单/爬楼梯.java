package 简单;

/**
 * @Description 70
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/18 12:04
 */
public class 爬楼梯 {

    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
