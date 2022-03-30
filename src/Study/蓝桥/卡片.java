package Study.蓝桥;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/23 21:55
 */
public class 卡片 {

    public static void main(String[] args) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++)
            nums[i] = 2021;
        int i = 1;
        for (; ; i++) {
            int cur = i;
            while (cur != 0) {
                nums[cur%10]--;
                if (nums[cur%10] == 0)
                    break;
                cur /= 10;
            }
            if (cur != 0)
                break;
        }
        System.out.println(i - 1);
    }
}
