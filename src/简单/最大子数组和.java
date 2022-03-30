package 简单;

/**
 * @Description 53
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 19:13
 */
public class 最大子数组和 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length]; //以nums[i]结尾的最大子数组和
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, dp[i]);
        return max;
    }
}
