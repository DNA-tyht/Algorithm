package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/28 10:11
 */
public class PackingMachine {

    public static int MinOps(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int size = arr.length, sum = 0;
        for (int i = 0; i < size; i++)
            sum += arr[i];
        if (sum % size != 0)
            return -1;
        int avg = sum/size;
        int leftSum = 0, ans = 0;
        for (int i = 0; i < size; i++) {
            int leftRest = leftSum - i * avg; //左侧需要的
            int rightRest = (sum - leftSum - arr[i]); //右侧需要的
            if (leftRest < 0 && rightRest < 0)
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            else
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            leftSum += arr[i];
        }
        return ans;
    }
}
