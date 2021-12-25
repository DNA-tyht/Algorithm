package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/25 11:28
 */
public class CoinWays {

    public static int way(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (index == arr.length)
            return rest == 0 ? 1 : 0;
        int ways = 0;
        for (int i = 0; arr[i] * i <= rest; i++)
            ways += process(arr, index + 1, rest - arr[index] * i);
        return ways;
    }

    private static int dp(int[] arr, int aim) {
        if (arr == null || arr.length == 0)
            return 0;
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest < aim + 1; rest++) {
                //int ways = 0;
                //for (int i = 0; arr[row] * i < aim; i++) {
                //    ways += dp[row + 1][col - arr[row] * i];
                //}
                //dp[row][col] = ways;
                //斜率优化：当发生枚举行为时观察是否可以用邻近的某个状态替代
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0)
                    dp[index][rest] += dp[index][rest - arr[index]];

            }
        }
        return dp[0][aim];
    }
}
