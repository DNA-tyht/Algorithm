package 中等;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 452
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 21:25
 */
public class 用最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1])); //按右端点排序
        int count = 1; //至少需要一支箭
        int axis = points[0][1];
        //贪心算法
        for (int i = 1; i < points.length; i++) {
            if (axis < points[i][0]) {
                count++;
                axis = points[i][1];
            }
        }
        return count;
    }
}
