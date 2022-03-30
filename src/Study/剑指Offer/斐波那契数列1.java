package Study.剑指Offer;

/**
 * @Description 10
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/15 13:25
 */
public class 斐波那契数列1 {

    public static int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2)
            return n;
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
