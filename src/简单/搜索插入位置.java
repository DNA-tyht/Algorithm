package 简单;

/**
 * @Description 35
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/16 14:52
 */
public class 搜索插入位置 {

    public int searchInsert(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return i;
            else if (nums[i] > target)
                break;
        }
        return i;
    }
}
