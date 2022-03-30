package 简单;

/**
 * @Description 278
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/16 14:36
 */
public class 第一个错误的版本 {

    public static int firstBadVersion(int n) {
        if (n == 1)
            return 1;
        int left = 1, right = n;
        int index = 0;
        while (left <= right) {
            index = left + (right - left)/2;
            if (left == right)
                break;
            if (isBadVersion(index))
                right = index;
            else
                left = index + 1;

        }
        return index;
    }

    public static boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
