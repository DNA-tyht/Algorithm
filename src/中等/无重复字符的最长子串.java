package 中等;

import java.util.HashMap;

/**
 * @Description 3
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/9 14:07
 */
public class 无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int left = 0, right = 0, max = 0;
        //只存储窗口内字符
        HashMap<Character, Integer> strMap = new HashMap<>();
        while (left <= right && right < s.length()) {
            if (strMap.get(s.charAt(right)) == null) {
                strMap.put(s.charAt(right), right);
            } else {
                Integer newIndex = strMap.get(s.charAt(right)); //移除后可能null所以保存
                //移除重复字符极其之前的字符
                while (left <= newIndex) {
                    strMap.remove(s.charAt(left), left);
                    left++;
                }
                strMap.put(s.charAt(right), right); //记得添加right
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
