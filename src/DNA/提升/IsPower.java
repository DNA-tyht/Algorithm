package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/23 14:07
 */
public class IsPower {

    public static boolean is2Power(int n) {
        return (n & (n - 1)) == 0;
    }

    public static boolean is4Power(int n) {
        return ((n & (n - 1)) == 0) && (n & 0x55555555) != 0;
    }
}
