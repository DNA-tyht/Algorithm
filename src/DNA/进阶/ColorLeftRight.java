package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 15:26
 */
public class ColorLeftRight {

    //左侧G，右侧R
    public static int minPaintTest(String s) {
        char[] str = s.toCharArray();
        int N = s.length(), min = Integer.MAX_VALUE;
        int[] ints = new int[N]; //加速数组，记录0~i范围内G的个数
        for (int i = 0; i < N; i++) {
            if (str[i] == 'R')
                ints[i] = (i == 0) ? 1 : ints[i - 1] + 1;
        }
        for (int L = 0; L < N; L++) { //枚举左侧的大小为L
            int cur = 0;
            if (L == 0)  //统计0~N-1所有的R染成G
                cur = ints[N - 1];
            else if (L == N - 1)  //统计0~N-1所有G染成R
                cur = N - ints[N - 1];
            else  //0~L上R染成G，L+1~N-1上G染成R
                cur = ints[L] + (N - (ints[N - 1] - ints[L + 1]));
            min = Math.min(cur, min);
        }
        return min;
    }
}
