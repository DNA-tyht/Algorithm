package Study.剑指Offer;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/22 14:31
 */
public class 青蛙跳台阶问题2 {

    public static int numWays(int n) {
        if (n == 0 || n == 1)
            return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % (1000000007);
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
