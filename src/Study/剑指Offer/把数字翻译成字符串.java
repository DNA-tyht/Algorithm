package Study.剑指Offer;

/**
 * @Description 46
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 19:53
 */
public class 把数字翻译成字符串 {

    public static int translateNum(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        return process(0, nums);
    }

    private static int process(int cur, char[] nums) {
        if (cur == nums.length)
            return 1;
        if (nums[cur] == '0') {
            return process(cur + 1, nums);
        }
        if (nums[cur] == '1') {
            int res = process(cur + 1, nums);
            if (cur + 1 < nums.length)
                res += process(cur + 2, nums);
            return res;
        }
        if (nums[cur] == '2') {
            int res = process(cur + 1, nums);
            if (cur + 1 < nums.length && (nums[cur + 1] >= '0' && nums[cur + 1] <= '5'))
                res += process(cur + 2, nums);
            return res;
        }
        return process(cur + 1, nums);
    }

    public static void main(String[] args) {
        System.out.println(translateNum(1250156147));
    }
}
