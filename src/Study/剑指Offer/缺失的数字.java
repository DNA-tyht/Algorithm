package Study.剑指Offer;

/**
 * @Description 53
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/19 20:25
 */
public class 缺失的数字 {

    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
