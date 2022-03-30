package Study.蓝桥;

import java.util.Scanner;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 18:25
 */
public class 特别数的和 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if (containNum(i))
                res += i;
        }
        System.out.println(res);
    }

    public static boolean containNum(int num) {
        while (num != 0) {
            int cur = num % 10;
            if (cur == 2 || cur == 0 || cur == 1 || cur == 9)
                return true;
            num /= 10;
        }
        return false;
    }
}
