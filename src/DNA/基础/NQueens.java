package DNA.基础;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/25 13:18
 */
public class NQueens {

    public static int num(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n]; //record[i] 第i行的皇后放在了第几列
        return process(0, record, n);
    }

    //i: 来到了第i行
    //record: 记录之前的棋盘
    //n: 一共有多少行
    //return: 合法的摆法有多少种
    public static int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            //判断第i行的皇后放在第j列是否合法
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
