package 中等;

/**
 * @Description 542
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/26 15:47
 */
public class 矩阵01 {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = process(mat, n, m, i, j) - 1;
            }
        }
        return res;
    }

    private int process(int[][] mat, int n, int m, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;
        if (mat[i][j] == 0)
            return 1;
        int count = 0;
        count += process(mat, n, m, i + 1, j);
        count += process(mat, n, m, i - 1, j);
        count += process(mat, n, m, i, j + 1);
        count += process(mat, n, m, i, j - 1);
        return count;
    }


}
