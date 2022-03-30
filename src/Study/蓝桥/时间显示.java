package Study.蓝桥;

import java.util.Scanner;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/25 12:59
 */
public class 时间显示 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        n /= 1000;
        n %= 60 * 60 *24;
        int hh = (int) (n / 3600);
        int mm = (int) ((n - hh * 3600) / 60);
        int ss = (int) (n - hh * 3600 - mm * 60);
        String s = String.format("%02d:%02d:%02d", hh, mm, ss);
        System.out.println(s);
    }
}
