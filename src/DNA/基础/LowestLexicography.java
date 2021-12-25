package DNA.基础;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/25 10:47
 */
public class LowestLexicography {

    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
