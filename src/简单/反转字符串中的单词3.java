package 简单;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/19 21:50
 */
public class 反转字符串中的单词3 {

    public static void main(String[] args) {
        System.out.println(reverseWords(" "));
    }

    public static String reverseWords(String s) {
        if (s.length() == 0)
            return "";
        StringBuilder builder = new StringBuilder();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                end = i - 1;
                for (int j = end; j >= start; j--) {
                    builder.append(s.charAt(j));
                }
                builder.append(' ');
                start = i + 1;
            }
        }
        int index = s.length() - 1;
        while (s.charAt(index) != ' ' && index >= 0)
            builder.append(s.charAt(index--));
        return builder.toString();
    }
}
