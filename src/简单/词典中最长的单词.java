package 简单;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description 720
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/18 10:23
 */
public class 词典中最长的单词 {

    public static String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length())
                return  a.length() - b.length();
            else
                return b.compareTo(a);
        });
        HashMap<Integer, String> strings = new HashMap<>();
        int index = 0;
        strings.put(index++, "");
        for (int i = 0; i < words.length; i++) {
            String word = words[i].substring(0, words[i].length() - 1);
            if (strings.containsValue(word))
                strings.put(index++, words[i]);
        }
        return strings.get(index - 1);
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[] {"w","wo","wor","worl","world"}));
    }
}
