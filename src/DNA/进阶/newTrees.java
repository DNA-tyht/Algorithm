package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/27 13:43
 */
public class newTrees {

    public static int process(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int res = 0;
        for (int leftNum = 0; leftNum < n; leftNum++) {
            int leftWays = process(leftNum);
            int rightWays = process(n - leftNum - 1);
            res += leftWays * rightWays;
        }
        return res;
    }

    //动态规划
    public static int newTrees(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n - 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
