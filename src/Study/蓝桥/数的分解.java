package Study.蓝桥;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 15:26
 */
public class 数的分解 {

    public static boolean containTwo (int x) {
        while (x != 0) {
            if (x % 10 == 2 || x % 10 == 4)
                return true;
            x /= 10;
        }
        return false;
    }

    static class NUM{
        int a;
        int b;
        int c;

        public NUM(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NUM num = (NUM) o;
            return a == num.a && b == num.b && c == num.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        Set<NUM> set = new HashSet<>();
        int n = 2019;
        for (int i = 1; i <= n - 2; i++) {
            if (containTwo(i))
                continue;
            for (int j = 1; j <= n - i - 1; j++) {
                int k = n - i - j;
                if (containTwo(j) || containTwo(k))
                    continue;
                if (i + j + k == n) {
                    int[] arr = new int[] {i, j, k};
                    Arrays.sort(arr);
                    set.add(new NUM(arr[0], arr[1], arr[2]));
                }
            }
        }
        for (NUM num : set)
            System.out.println(num.a + " " + num.b + " " + num.c);
        System.out.println(set.size());
    }
}
