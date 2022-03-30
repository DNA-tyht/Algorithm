package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/28 15:51
 */
public class MinOps {

    public static int minOps(int n) {
        if (n < 2)
            return 0;
        if (isPrim(n))
            return n -1;
        int[] divSumAndCount = divSumAndCount(n);
        return divSumAndCount[0] - divSumAndCount[1];
    }

    private static boolean isPrim(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    //保证n不是质数
    public static int[] divSumAndCount(int n) {
        int sum = 0, count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                sum += i;
                count++;
                n /= i;
            }
        }
        return new int[]{sum, count};
    }
}
