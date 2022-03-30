package 中等;

import java.util.Arrays;

/**
 * @Description 984
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 15:59
 */
public class 不含AAA或BBB的字符串 {

    public String strWithout3a3b(int a, int b) {
        StringBuilder s = new StringBuilder();
        while (a > 0 && b > 0) {
            if (a > b) {
                s.append("aab");
                a -= 2;
                b -= 1;
            } else if (b > a) {
                s.append("bba");
                a -= 1;
                b -= 2;
            } else {
                s.append("ab");
                a--;
                b--;
            }
        }
        while (a-- != 0) s.append("a");
        while (b-- != 0) s.append("b");
        return s.toString();
    }
}
