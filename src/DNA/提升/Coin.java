package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/24 11:17
 */
public class Coin {

    public static int minCoin(int[] coins, int aim) {
        //return f(coins, 0, 0, aim);
        int[][] dp = new int[coins.length + 1][aim + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = -2;
            }
        }
        return process(coins, 0, aim, dp);
    }

    private static int process(int[] coins, int index, int aim, int[][] dp) {
        if (aim < 0)
            return -1;
        if (dp[index][aim] != -2)
            return dp[index][aim];
        if (aim == 0) {
            dp[index][aim] = 0;
            return 0;
        }
        //aim > 0
        if (index == coins.length) {
            dp[index][aim] = -1;
            return -1;
        }
        int p1 = process(coins, index + 1, aim, dp);
        int p2 = 1 + process(coins, index + 1, aim - coins[index], dp);
        if (p1 == -1 && p2 == -1) {
            dp[index][aim] = -1;
            return -1;
        }
        else {
            if (p1 == -1) {
                dp[index][aim] = p2;
                return p2;
            }
            if (p2 == -1) {
                dp[index][aim] = p1;
                return p1;
            }
            dp[index][aim] = Math.min(p1, p2);
        }
        return dp[index][aim];
    }

    private static int f(int[] coins, int index, int pre, int aim) {
        if (index == coins.length) {
            return pre == aim ? 1 : 0;
        }
        return f(coins, index + 1, pre, aim) + f(coins, index + 1, pre + coins[index], aim);
    }

    public static int minCoins(int[] coins, int aim) {
        int[][] dp = new int[coins.length + 1][aim + 1];
        for (int row = 0; row < coins.length + 1; row++)
            dp[row][0] = 0;
        for (int col = 1; col < aim + 1; col++)
            dp[coins.length][col] = -1;
        for (int index = coins.length - 1; index >= 0; index--) {
            for (int rest = 1; rest < aim + 1; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if (rest - coins[index] >= 0)
                    p2 = dp[index + 1][rest - coins[index]] + 1;
                if (p1 == -1 && p2 == -1)
                    dp[index][rest] = -1;
                else {
                    if (p1 == -1)
                        dp[index][rest] = p2;
                    if (p2 == -1)
                        dp[index][rest] = p1;
                    dp[index][rest] = Math.min(p1, p2);
                }
            }
        }
        return dp[0][aim];
    }
}
