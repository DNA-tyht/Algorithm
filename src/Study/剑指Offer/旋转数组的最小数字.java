package Study.剑指Offer;

import java.util.Arrays;

/**
 * @Description 11
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/20 13:36
 */
public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
