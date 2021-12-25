package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/23 11:21
 */
public class GetMax {

    //保证参数为 0|1
    //并将0转换为1，1转换成0
    public static int flip(int n) {
        return n ^ 1;
    }

    //正数返回1，负数返回0
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    //互斥条件可以代替比较条件
    //a b可能溢出
    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c); //判断a-b的符号
        int scB = flip(scA); //两数中大的数的乘数一定为1，较小数为0
        return a * scA + b * scB;
    }

    //考虑溢出
    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb; //判断a b符号是否相同
        int sameSab = flip(difSab); //对dif取反
        //a b符号相同则取a符号，a b符号不同则取c符号
        int returnA = difSab * sa + sameSab * sc; //选择，+两边取其一
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }
}
