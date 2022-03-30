package 简单;

import java.util.HashMap;

/**
 * @Description 1
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/9 12:50
 */
public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            if (numMap.get(tar) != null && numMap.get(tar) != i)
                return new int[] {i, numMap.get(tar)};
        }
        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[] {3, 2, 4}, 6));
    }
}
