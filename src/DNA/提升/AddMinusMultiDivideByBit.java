package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/23 14:31
 */
public class AddMinusMultiDivideByBit {

    public static int add (int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int minus (int a, int b) {
        return add(a, negNum(b));
    }

    public static int multi (int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            b  >>>= 1; //无符号右移
            a <<= 1;
        }
        return res;
    }

    public static int div (int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= 1 << i;
                x = minus(x, y << 1);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    private static boolean isNeg(int n) {
        return n < 0;
    }

    public static int negNum (int n) {
        return add(~n, 1); //取反加1
    }
}
