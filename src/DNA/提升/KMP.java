package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/1 15:38
 */
public class KMP {

    public static int KMP (String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int x = 0;
        int y = 0;
        int[] next = getNextArray(str2);
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1){
                x++;
            } else {
                y = next[y];
            }
        }
        return y == str2.length ? x - y : -1;
    }

    private static int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int [str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0; //前缀的下一个值，使用的信息长度
        while (i < next.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) { //当前跳到cn位置的字符，和i-1不匹配
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    private static int BF (String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int x = 0;
        int y = 0;
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else {
                x = x - y + 1;
                y = 0;
            }
        }
        return y == str2.length ? x - y : -1;
    }
}
