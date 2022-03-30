package 简单;

import java.util.HashMap;

/**
 * @Description 169
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 17:29
 */
public class 多数元素 {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> arr = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            arr.put(nums[i], arr.get(nums[i]) == null ? 1 : arr.get(nums[i]) + 1);
            if (arr.get(nums[i]) > nums.length/2)
                return nums[i];
        }
        return -1;
    }
}
