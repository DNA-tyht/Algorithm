package Study.面试题;

import java.util.HashMap;

/**
 * @Description 50
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/20 13:41
 */
public class 第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null)
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return ' ';
    }
}
