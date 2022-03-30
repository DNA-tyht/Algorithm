package Study.剑指Offer;

/**
 * @Description 21
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/27 16:01
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] % 2 == 1)
                left++;
            else if (nums[right] % 2 == 0)
                right--;
            else {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
