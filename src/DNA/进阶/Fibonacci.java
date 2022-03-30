package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/13 14:21
 */
public class Fibonacci {

    public static int fi(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0]; //F(N) = 第一列相加
    }

    //求a^N
    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++)
            res[i][i] = 1;
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0)
                res = multiMatrix(res, tmp); //res = res*tmp^(p^2)
            tmp = multiMatrix(tmp, tmp); //tmp = tmp^2
        }
        return res;
    }

    private static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] = m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
