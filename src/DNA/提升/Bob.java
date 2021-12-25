package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/25 11:09
 */
public class Bob {

    public static double bobLive(int x, int y, int a, int b, int step) {
        double all = Math.pow(4, step);
        double live = process(x, y, a, b, step);
        return live/all;
    }

    //不考虑Bob会死的总情况：4^k
    //x*y 的区域，Bob在(a, b)位置，走step步后，获得的生存方法数
    public static long process(int x, int y, int a, int b, int step) {
        if (a < 0 || b < 0 || a == x || b == y)
            return 0;
        if (step == 0)
            return 1;
        long live = 0;
        live += process(x, y, a + 1, b, step - 1);
        live += process(x, y, a, b + 1, step - 1);
        live += process(x, y, a, b - 1, step - 1);
        live += process(x, y, a - 1, b, step - 1);
        return live;
    }
}
