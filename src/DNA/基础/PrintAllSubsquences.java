package DNA.基础;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/26 15:16
 */
public class PrintAllSubsquences {

    public static void printAllSubsquences(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    //res: 在i位置前形成的子字符串
    private static void process(char[] str, int i, List<Character> res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        List<Character> resKeep  = res;
        resKeep.add(str[i]);
        process(str, i + 1, resKeep); //要当前字符
        List<Character> resNoKeep  = res;
        process(str, i + 1, resNoKeep); //不要当前字符
    }

    //节省空间版
    private static void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        process(str, i + 1); //要当前字符
        char tmp = str[i];
        str[i] = 0;
        process(str, i + 1); //不要当前字符
        str[i] = tmp;
    }
}
