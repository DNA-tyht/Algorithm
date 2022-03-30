package 简单;

/**
 * @Description 509
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 19:37
 */
public class 斐波那契数 {

    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
