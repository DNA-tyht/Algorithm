package 简单;

import java.util.Arrays;

/**
 * @Description 283
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/18 11:18
 */
public class 移动零 {

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        for (left = 0; left < nums.length; left++) {
            if (nums[left] != 0)
                nums[right++] = nums[left];
        }
        while (right < nums.length)
            nums[right++] = 0;
    }
}
