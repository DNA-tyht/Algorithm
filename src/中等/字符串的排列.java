package 中等;

import java.util.Arrays;

/**
 * @Description 567
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/26 13:46
 */
public class 字符串的排列 {

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        int left = 0, right = 0;
        int n = s1.length();
        for (; right < n; right++) {
            map2[s2.charAt(right) - 'a']++;
            map1[s1.charAt(right) - 'a']++;
        }
        if (Arrays.equals(map1, map2))
            return true;
        while (right < s2.length()) {
            map2[s2.charAt(left++) - 'a']--;
            map2[s2.charAt(right++) - 'a']++;
            if (Arrays.equals(map1, map2))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "abc"));
    }
}
