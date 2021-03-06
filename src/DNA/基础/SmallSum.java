package DNA.基础;

/**
 * @Description 小和问题
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/10/10 16:24
 */
public class SmallSum {

    private static void smallSun(int[] arr) {
        if (arr != null && arr.length > 0) {
            process(arr, 0, arr.length - 1);
        }
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R)
            return 0;
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0, p1 = L, p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            res += arr[p1] < arr[p2] ? (res - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M)
            help[i++] = arr[p1++];
        while (p2 <= R)
            help[i++] = arr[p2++];
        for (i = 0; i < help.length; i++)
            arr[L + i] = help[i];
        return res;
    }
}
