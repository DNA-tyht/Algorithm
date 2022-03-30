package 中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 539
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/18 13:20
 */
public class 最小时间差 {

    public static int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        int index = 0;
        for (String time : timePoints) {
            char[] chars = time.toCharArray();
            times[index++] = ((chars[0] - '0')*10 + (chars[1] - '0')) * 60 + ((chars[3] - '0')*10 + (chars[4] - '0'));
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < times.length; i++) {
            min = Math.min(min, times[i] - times[i - 1]);
            if (min == 0)
                break;
        }
        min = Math.min(min, 24*60 + times[0] - times[times.length - 1]);
        return min;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("23:59");
        strings.add("00:00");
        System.out.println(findMinDifference(strings));
    }
}
