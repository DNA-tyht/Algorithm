package DNA.进阶;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/27 14:49
 */
public class MagicOp {

    public static int maxOps(int[] a, int[] b) {
        double sumA = 0;
        for (int i = 0; i < a.length; i++)
            sumA += a[i];
        double sumB = 0;
        for (int i = 0; i < b.length; i++)
            sumB += b[i];
        if (avg(sumA, a.length) == avg(sumB, b.length))
            return 0;
        int[] arrMore = null, arrLess = null;
        double sumMore = 0, sumLess = 0;
        if (avg(sumA, a.length) > avg(sumB, b.length)) {
            arrMore = a;
            sumMore = sumA;
            arrLess = b;
            sumLess = sumB;
        } else {
            arrMore = b;
            sumMore = sumB;
            arrLess = a;
            sumLess = sumA;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for (int num : arrLess)
            setLess.add(num);
        int moreSize = arrMore.length; //平均大的集合个数
        int lessSize = arrLess.length; //平均大的集合个数
        int ops = 0; //操作了多少次
        for (int i = 0; i < arrMore.length; i++) { //开始搬家
            double cur = arrMore[i];
            if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize) && !setLess.contains(arrMore[i])) {
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(arrMore[i]);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double n, int l) {
        return n/l;
    }
}
