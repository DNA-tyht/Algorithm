package Study.剑指Offer;

/**
 * @Description 5
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/18 11:40
 */
public class 替换空格 {

    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                stringBuilder.append("%20");
            else
                stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
