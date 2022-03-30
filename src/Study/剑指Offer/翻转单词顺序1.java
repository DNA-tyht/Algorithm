package Study.剑指Offer;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/27 16:24
 */
public class 翻转单词顺序1 {

    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals(""))
                continue;
            System.out.println(strings[i].trim());
            if (i == 0) //string.trim去空格
                stringBuilder.append(strings[i].trim());
            else
                stringBuilder.append(strings[i].trim()).append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
