package 简单;

/**
 * @Description 344
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/19 21:46
 */
public class 反转字符串 {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
