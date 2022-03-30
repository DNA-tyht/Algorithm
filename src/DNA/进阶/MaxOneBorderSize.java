package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/27 10:04
 */
public class MaxOneBorderSize {

    public static int maxAllOneBorder(int[][] m) {
        int N = m.length; //行
        int M = m[0].length; //列
        int max = Integer.MIN_VALUE;
        int[][] right = new int[N][M]; //预处理矩阵：包括自己在内，右边1的个数
        int[][] down = new int[N][M]; //预处理矩阵：包括自己在内，下方1的个数
        if (m[N - 1][M - 1] == 1) {
            right[N - 1][M - 1] = 1;
            down[N - 1][M - 1] = 1;
        }
        for (int i = N - 2; i != -1; i--) {
            if (m[i][M - 1] == 1) {
                right[i][M - 1] = 1;
                down[i][M - 1] = down[i + 1][M - 1] + 1;
            }
        }
        for (int i = M - 2; i != -1; i--) {
            if (m[N - 1][i] == 1) {
                right[N - 1][i] = right[N - 1][i + 1] + 1;
                down[N - 1][i] = 1;
            }
        }
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                for (int border = 1; border < Math.min(N - row, M - col); border++) { //枚举变长
                    //左上：(row, col)，边长只向右下延伸
                    //开始验证正方形边界是否全1
                }
            }
        }
        return max;
    }
}
