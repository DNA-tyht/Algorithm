package Study.剑指Offer;

/**
 * @Description 42
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/23 20:38
 */
public class 连续子数组的最大和 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
