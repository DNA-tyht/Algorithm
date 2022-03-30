package 困难;

/**
 * @Description 1220
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 19:51
 */
public class 统计元音字母序列的数目 {

    public int countVowelPermutation(int n) {
        int mod = (int) (1e9 + 7);
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int index = 2; index <= n; index++) {
            long aa = (e) % mod;
            long ee = (a + i) % mod;
            long ii = (a + e + o + u) % mod;
            long oo = (i + u) % mod;
            long uu = (a) % mod;
            a = aa;
            e = ee;
            i = ii;
            o = oo;
            u = uu;
        }
        return (int) ((a + e + i + o + u) % mod);
    }
}
