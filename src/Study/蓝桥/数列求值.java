package Study.蓝桥;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 15:20
 */
public class 数列求值 {

    public static void main(String[] args) {
        int a = 1, b = 1, c = 1, d = 0;
        for (int i = 4; i <= 20190324; i++) {
            d = (a + b + c) % 10000;
            a = b;
            b = c;
            c = d;
        }
        System.out.println(d);
    }
}
