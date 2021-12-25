package DNA.基础;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/27 14:37
 */
public class CardsInLine {

    //先手
    public static int firstHand(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + firstHand(arr, i + 1, j), arr[j] + firstHand(arr, i, j - 1));
    }
    //后手
    public static int backHand(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.max(backHand(arr, i + 1, j), backHand(arr, i, j - 1));
    }

    public static int win(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(firstHand(arr, 0, arr.length - 1), backHand(arr, 0, arr.length - 1));
    }
}
