package DNA.基础;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/27 15:21
 */
public class MaxValue {

    //i: 当前所装货物数量
    //alreadyWeight: 当前所装货物重量
    public static int process(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag || i == weights.length) {
            return 0;
        }
        return Math.max(process(weights, values, i + 1, alreadyWeight, bag), //不要i号货物
                        values[i] + process(weights, values, i + 1, alreadyWeight + weights[i], bag)); //要i号货物
    }

    public static int maxValue(int[] weights, int[] values, int bag) {
        return process(weights, values, 0, 0, bag);
    }
}
