package Study.蓝桥;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/25 14:10
 */
public class 双向排序 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long m = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            nums.add(i);
        for (int i = 0; i < m; i++) {
            long p = scanner.nextInt();
            long q = scanner.nextInt();
            if (p == 0)
                nums.subList(0, (int) (q)).sort(Collections.reverseOrder());
            else
                Collections.sort(nums.subList((int) q - 1, (int) n));
        }
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
