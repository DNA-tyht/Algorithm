package Study.蓝桥;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 17:57
 */
public class 迷宫 {

    public static void main(String[] args) {
        int[][] map = new int[][] {
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0, 0}
        };
        int[][] dp = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1)
                    dp[i][j] = -1;
                else
                    dp[i][j] = 0;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                //if (i == 0)
            }
        }
    }
}
