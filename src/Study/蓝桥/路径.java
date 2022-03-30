package Study.蓝桥;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/25 12:16
 */
public class 路径 {

    static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int lcm (int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        int[] dp = new int[2022];
        for (int i = 2; i < 2022; i++) {
            int minRoute = Integer.MAX_VALUE;
            for (int j = i - 1; i - j <= 21 && j > 0; j--) {
                int length = lcm(i, j);
                minRoute = Math.min(minRoute, length + dp[j]);
            }
            dp[i] = minRoute;
        }
        System.out.println(dp[2021]);
    }

}
