package Study.剑指Offer;

import java.util.HashSet;

/**
 * @Description 3
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/19 20:17
 */
public class 数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return 0;
    }
}
