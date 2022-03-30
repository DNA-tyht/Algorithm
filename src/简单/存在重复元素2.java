package 简单;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description 219
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/19 22:33
 */
public class 存在重复元素2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //维护一个大小为k的哈希表
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i]))
                return true;
            hashSet.add(nums[i]);
            if (hashSet.size() > k)
                hashSet.remove(nums[i - k]);
        }
        return false;
    }
}
