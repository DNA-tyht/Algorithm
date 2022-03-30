package 简单;

import java.util.HashMap;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/18 11:34
 */
public class 两数之和输入有序数组 {

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++)
            map.put(numbers[i], i);
        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            if (map.get(num) != null) {
                return new int[] {i + 1, map.get(num) + 1};
            }
        }
        return new int[] {0, 0};
    }
}
