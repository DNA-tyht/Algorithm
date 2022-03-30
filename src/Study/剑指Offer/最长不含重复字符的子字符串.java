package Study.剑指Offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 48
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/26 20:29
 */
public class 最长不含重复字符的子字符串 {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = 0;
        while (left <= right && right < s.length()) {

            char cur = s.charAt(right);
            if (!set.contains(cur))
                set.add(cur);
            else {
                res = Math.max(res, right - left);
                while (s.charAt(left) != cur) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        res = Math.max(res, right - left);
        return left == 0 ? s.length() : res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
