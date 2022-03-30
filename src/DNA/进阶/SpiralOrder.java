package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/28 10:46
 */
public class SpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        while (tR < dR && tC <= dC)
            printEdge(matrix, tR++, tC++, dR--, dC--);
    }

    public static void printEdge(int[][]arr, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++)
                System.out.println(arr[a][i] + " ");
        } else if (b == d) {
            for (int i = a; i <= c; i++)
                System.out.println(arr[i][b] + " ");
        } else {
            int curC = b, curR = a;
            while (curC != d) {
                System.out.println(arr[a][curC] + " ");
                curC++;
            }
            while (curR != c) {
                System.out.println(arr[curR][d] + " ");
                curR++;
            }
            while (curC != b) {
                System.out.println(arr[c][curC] + " ");
                curC--;
            }
            while (curR != a) {
                System.out.println(arr[curR][b] + " ");
                curR--;
            }
        }
    }
}
