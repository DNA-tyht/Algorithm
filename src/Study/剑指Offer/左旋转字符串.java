package Study.剑指Offer;

import java.util.Arrays;

/**
 * @Description 58
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/18 11:44
 */
public class 左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        n %= s.length();
        StringBuilder chars = new StringBuilder();
        int index = 0;
        for (int i = n; i < s.length(); i++)
            chars.append(s.charAt(i));
        for (int i = 0; i < n; i++)
            chars.append(s.charAt(i));
        return chars.toString();
    }
}
