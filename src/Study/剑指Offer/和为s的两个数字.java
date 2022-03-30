package Study.剑指Offer;

import java.util.Arrays;

/**
 * @Description 57
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/27 16:14
 */
public class 和为s的两个数字 {

    public int[] twoSum(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[] {nums[left], nums[right]};
            else if (sum > target)
                right--;
            else
                left++;
        }
        return null;
    }
}
