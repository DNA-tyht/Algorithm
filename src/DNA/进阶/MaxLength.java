package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/27 16:30
 */
public class MaxLength {

    public static int maxLength(String s) {
        if (s == null || s.equals(""))
            return 0;
        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        int pre = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1; //溯回查看是否与i配对
                if (pre >= 0 && pre == '(')
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
