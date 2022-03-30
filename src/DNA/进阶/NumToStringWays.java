package DNA.进阶;

import java.util.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/27 17:17
 */
public class NumToStringWays {

    public static int convertWays(int num) {
        if (num < 1) return 0;
        return process(String.valueOf(num).toCharArray(), 0);
    }

    private static int process(char[] str, int index) {
        if (index == str.length)
            return 1;
        if (str[index] == '0')
            return 0;
        int res = process(str, index + 1); //index作一部分
        if (index == str.length - 1)
            return res;
        if (((str[index] - '0') * 10 + str[index + 1] - '0') <= 26)
            res += process(str, index + 2);
        return res;
    }
}
