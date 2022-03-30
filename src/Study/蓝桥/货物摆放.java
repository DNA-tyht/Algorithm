package Study.蓝桥;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/25 11:58
 */
public class 货物摆放 {

    public static void main(String[] args) {
        long n = 2021041820210418L;
        Set<Long> set = new HashSet<>();
        for (long i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n/i);
            }
        }
        int count = 0;
        for (Long L : set)
            for (Long W : set)
                for (Long H :set)
                    if (L * W * H == n)
                        count++;
        System.out.println(count);
    }
}
