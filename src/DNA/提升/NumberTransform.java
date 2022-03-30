package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/27 15:10
 */
public class NumberTransform {

    //i之前的位置已经决定好了
    //现在决定i后的位置
    public static int process(char[] str, int i) {
        if (i == str.length)  {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = process(str, i + 1); //将i作为单独的部分
            if (i + 1 < str.length) {
                res += process(str, i + 2); //将i和i+1作为一部分
            }
            return res;
        }
        if (str[i] == '2') {
            int res = process(str, i + 2);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }
        //str[i] == '3' ~ '9'
        return process(str, i + 1);
    }
}
