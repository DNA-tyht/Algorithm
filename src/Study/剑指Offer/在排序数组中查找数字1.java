package Study.剑指Offer;

/**
 * @Description 53
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/19 20:22
 */
public class 在排序数组中查找数字1 {

    public int search(int[] nums, int target) {
        int res = 0;
        for (int num : nums) {
            if (num == target)
                res++;
            else if (num > target)
                break;
        }
        return res;
    }
}
