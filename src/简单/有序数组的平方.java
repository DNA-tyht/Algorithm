package 简单;

/**
 * @Description 977
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 10:54
 */
public class 有序数组的平方 {

    public int[] sortedSquares(int[] nums) {
        if (nums.length == 0)
            return new int[] {};
        if (nums.length == 1)
            return new int[] {nums[0] * nums[0]};
        int[] res = new int[nums.length];
        int left = -1, right = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= 0 && nums[i] > 0) {
                left = i - 1;
                right = i;
                break;
            }
            if (i == nums.length - 1) {
                if (nums[i] <= 0)
                    left = nums.length - 1;
                else
                    right = 0;
            }
        }
        int index = 0;
        while (left >= 0 && right <= nums.length - 1) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[index] = (int) Math.pow(nums[left], 2.0);
                left--;
            } else {
                res[index] = (int) Math.pow(nums[right], 2.0);
                right++;
            }
            index++;
        }
        while (left >= 0) {
            res[index] = (int) Math.pow(nums[left], 2.0);
            left--;
            index++;
        }
        while (right <= nums.length - 1) {
            res[index] = (int) Math.pow(nums[right], 2.0);
            right++;
            index++;
        }
        return res;
    }
}
