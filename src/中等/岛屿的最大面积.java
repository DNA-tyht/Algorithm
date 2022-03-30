package 中等;

/**
 * @Description 695
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/26 14:42
 */
public class 岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0] == null)
            return 0;
        int n = grid.length, m = grid[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, process(grid, i, j, n, m));
                }
            }
        }
        return max;
    }

    private int process(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1)
            return 0;
        grid[i][j] = 2;
        int count = 1;
        count += process(grid, i + 1, j, n, m);
        count += process(grid, i - 1, j, n, m);
        count += process(grid, i, j + 1, n, m);
        count += process(grid, i, j - 1, n, m);
        return count;
    }
}
