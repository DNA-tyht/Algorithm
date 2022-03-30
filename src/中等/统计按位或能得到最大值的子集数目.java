package 中等;

/**
 * @Description 2044
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/15 12:01
 */
public class 统计按位或能得到最大值的子集数目 {

    public static int ans = 0;

    public static int countMaxOrSubsets(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++)
            res |= nums[i];
        process(nums, res, 0, 0);
        return ans;
    }

    private static void process(int[] nums, int res, int cur, int n) {
        if (nums.length == n) {
            if (res == cur)
                ans++;
            return;
        }
        process(nums, res, cur, n + 1);
        process(nums, res, cur|nums[n], n + 1);
    }

    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[] {2, 2, 2}));
    }
}
