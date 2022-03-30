package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/27 14:04
 */
public class NeedParentheses {

    public static int neeParentheses(String str) {
        int count = 0, ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                count++;
            else {
                if (count == 0) ans++;
                else count--;
            }
        }
        return count + ans;
    }
}
