package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/25 10:03
 */
public class HorseJump {

    public static int getWays(int x, int y, int k) {
        return process(x, y, k);
    }

    //马走日：先横着或直着走一格，然后再斜着走一个对角线
    private static int process(int x, int y, int step) {
        if (x < 0 || y < 0 || x > 8 || y > 9)
            return 0;
        if (step == 0)
            return (x ==0 && y == 0) ? 1 : 0;
        return  process(x - 1, y + 2, step - 1) +
                process(x + 1, y + 2, step - 1) +
                process(x + 2, y + 1, step - 1) +
                process(x + 2, y - 1, step - 1) +
                process(x + 1, y - 2, step - 1) +
                process(x - 1, y - 2, step - 1) +
                process(x - 2, y - 1, step - 1) +
                process(x - 2, y + 1, step - 1);
    }

    private static int dpWap(int x, int y, int step) {
        if (x < 0 || y < 0 || x > 8 || y > 9 || step < 0)
            return 0;
        int[][][] dp = new int[9][10][step + 1];
        dp[0][0][0] = 1;
        for (int h = 1; h < step + 1; h++) { //step层
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 10; c++) {
                    dp[r][c][h] += getValue(dp, r - 1, c + 2, h -1);
                    dp[r][c][h] += getValue(dp, r - 1, c - 2, h -1);
                    dp[r][c][h] += getValue(dp, r + 1, c + 2, h -1);
                    dp[r][c][h] += getValue(dp, r + 1, c - 2, h -1);
                    dp[r][c][h] += getValue(dp, r - 2, c + 1, h -1);
                    dp[r][c][h] += getValue(dp, r - 2, c - 1, h -1);
                    dp[r][c][h] += getValue(dp, r + 2, c + 1, h -1);
                    dp[r][c][h] += getValue(dp, r + 2, c - 1, h -1);
                }
            }
        }
        return dp[x][y][step];
    }

    private static int getValue(int[][][] dp, int x, int y, int step) {
        if (x < 0 || y < 0 || x > 8 || y > 9)
            return 0;
        return dp[x][y][step];
    }
}
