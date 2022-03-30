package 简单;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description 389
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 18:14
 */
public class 找不同 {

    //异或实现
    public char findTheDifference1(String s, String t) {
        char res = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            res ^= s.charAt(i) ^ t.charAt(i);
        }
        res ^= t.charAt(i);
        return res;
    }

    //hash表实现
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char diff = 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for (int i = 0; i < tt.length; i++) {
            map.put(tt[i], map.get(tt[i]) == null ? 1 : map.get(tt[i]) + 1);
        }
        for (int i = 0; i < ss.length; i++) {
            if(map.get(ss[i]) != null) {
                if (map.get(ss[i]) == 1) map.remove(ss[i]);
                else map.put(ss[i], map.get(ss[i]) - 1);
            }
        }
        for (Character key : map.keySet()) {
            diff = key;
        }
        return diff;
    }
}
