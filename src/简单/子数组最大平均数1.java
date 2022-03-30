package 简单;

/**
 * @Description 643
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/29 15:53
 */
public class 子数组最大平均数1 {

    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = k;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        maxSum = Math.max(sum, maxSum);
        while (right < nums.length) {
            sum -= nums[left];
            sum += nums[right];
            maxSum = Math.max(sum, maxSum);
            left++;
            right++;
        }
        return ((double)(maxSum))/k;
    }
}
