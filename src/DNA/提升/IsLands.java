package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/29 16:04
 */
public class IsLands {

    public static int countLands(int[][] arr) {
        if (arr == null || arr[0] == null) {
            return 0;
        }
        int N = arr.length;
        int M = arr[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    res++;
                    infect(arr, i, j, N, M);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] arr, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || arr[i][j] != 1) {
            return;
        }
        arr[i][j] = 2; //将计数后的岛变为2
        infect(arr, i + 1, j, N, M);
        infect(arr, i - 1, j, N, M);
        infect(arr, i, j + 1, N, M);
        infect(arr, i, j - 1, N, M);
    }
}
