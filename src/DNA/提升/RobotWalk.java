package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/24 10:13
 */
public class RobotWalk {

    public static int walkWays(int N, int E, int S, int K) {
        return f(N, E, K, S);
    }
    //rest：还有rest步要走
    //返回方法数
    private static int f(int n, int end, int rest, int cur) {
        if (rest == 0)
            return cur == end ? 1 : 0;
        if (cur == 1)
            return f(n, end, rest -1, 2);
        if (cur == n)
            return f(n, end,  rest - 1, n -1);
        return f(n, end, rest - 1, cur - 1) + f (n, end, rest - 1, cur + 1);
    }

    //记忆优化
    public static int walkWays1(int N, int E, int S, int K) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return f1(N, E, K, S, dp);
    }

    private static int f1(int n, int end, int rest, int cur, int[][] dp) {
        if (dp[rest][cur] != -1) //缓存命中
            return dp[rest][cur];
        //缓存未命中
        if (rest == 0) {
            dp[rest][cur] = cur == end ? 1 : 0;
            return dp[rest][cur];
        }
        if (cur == 1) {
            dp[rest][cur] = f(n, end, rest - 1, 2);
            return dp[rest][cur];
        }
        if (cur == n) {
            dp[rest][cur] = f(n, end, rest - 1, n - 1);
            return dp[rest][cur];
        }
        dp[rest][cur] = f(n, end, rest - 1, cur - 1) + f (n, end, rest - 1, cur + 1);
        return dp[rest][cur];
    }
}
