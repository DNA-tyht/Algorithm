package Study.蓝桥;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 15:03
 */
public class 不同子串 {

    public static void main(String[] args) {
        String s = "0100110001010001";
        Set<String> strings = new HashSet<>();
        for (int i = 1; i < s.length(); i++) {
            int count = 0;
            int curLevel = (int) Math.pow(2, i);
            int left = 0;
            int right = i;
            while (right <= s.length()) {
                if (!strings.contains(s.substring(left, right))) {
                    strings.add(s.substring(left, right));
                    System.out.println(s.substring(left, right));
                    count++;
                }
                if (count == curLevel)
                    break;
                left++;
                right++;
            }
        }
        System.out.println(strings.size() + 1);
    }
}
