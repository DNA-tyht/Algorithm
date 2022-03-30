package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/28 15:00
 */
public class ZigZagMatrix {

    //r:行c:列
    public static void printMatrixZigZag(int[][] matrix) {
        int ar = 0, ac = 0, br = 0, bc = 0;
        int endR = matrix.length - 1, endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (ar != endR + 1) {
            printLevel(matrix, ar, ac, br, bc, fromUp);
            ar = ac == endC ? ar + 1 : ar;
            ac = ac == endC ? ac : ac + 1;
            bc = br == endR ? bc + 1 : bc;
            br = br == endR ? br : br + 1;
            fromUp = ! fromUp;
        }
        System.out.println();
    }

    private static void printLevel(int[][] matrix, int ar, int ac, int br, int bc, boolean fromUp) {
        if (fromUp) {
            while (ar != br + 1)
                System.out.println(matrix[ar++][ac++] + " ");
        } else {
            while (br != ar - 1)
                System.out.println(matrix[br--][bc] + " ");
        }
    }
}
