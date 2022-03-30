package 简单;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description 217
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 19:02
 */
public class 存在重复元素 {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }
}
