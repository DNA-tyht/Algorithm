package DNA.基础;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/26 15:04
 */
public class Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "左", "右", "中");
        }
    }

    public static void func(int n, String start, String end, String other) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + start + " to " + end);
        } else {
            func(n - 1, start, other, end);
            System.out.println("Move " + n + " from " + start + " to " + end);
            func (n - 1, other, end, start);
        }
    }
}
