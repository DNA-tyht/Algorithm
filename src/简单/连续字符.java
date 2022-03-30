package 简单;

/**
 * @Description 1446
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 15:41
 */
public class 连续字符 {

    public static int maxPower(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right, max = 0, cur = 0;
        for (right = 0; right < chars.length; right++) {
            if (chars[left] == chars[right])
                cur++;
            else {
                left = right--;
                max = Math.max(cur, max);
                cur = 0;
            }
        }
        return Math.max(cur, max);
    }

    public static void main(String[] args) {
        System.out.println(maxPower("j"));
    }
}
