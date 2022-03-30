package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 13:50
 */
public class AppleBags {


    public static int minBags(int n) {
        if (n%2 == 1 || n < 0)
            return -1;
        int bag8 = n/8, bag6 = -1, rest = n - bag8 * 8;
        while (bag8 >= 0 && rest < 24) {
            int resUse6 = rest % 6 == 0 ? (rest / 6) : -1;
            if (resUse6 != -1) {
                bag6 = resUse6;
                break;
            }
            rest = n - (--bag8) * 8;
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    //打表找规律
    public static int minBagAwesome(int n) {
        if ((n & 1) != 0)
            return -1;
        if (n < 18)
            return n == 0 ? 0 : (n == 6 || n == 8) ? 1
                    : (n == 12 || n == 14 || n == 16) ? 2 : -1;
        return (n - 18) / 8 + 3;
    }
}
