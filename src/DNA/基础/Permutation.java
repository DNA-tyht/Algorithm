package DNA.基础;

import java.util.ArrayList;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/26 15:36
 */
public class Permutation {

    public static ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    //str[i...]范围上所有的字符都可以在i位置
    //0-i范围上是之前做的选择
    private static void process(char[] str, int i, ArrayList<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) { //去重操作
                visit[str[j] - 'a'] = true;
                swap(str, i, j); //直接修改str的布局，节省空间
                process(str, i + 1, res);
                swap(str, i, j); //将布局修改回来
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
