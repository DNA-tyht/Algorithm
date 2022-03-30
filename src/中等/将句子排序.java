package 中等;

import java.util.Arrays;

/**
 * @Description 1859
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/17 22:02
 */
public class 将句子排序 {

    public String sortSentence(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");

        Arrays.sort(strs, (o1, o2) -> {
            int n1 = o1.charAt(o1.length() - 1);
            int n2 = o2.charAt(o2.length() - 1);
            return Integer.compare(n1, n2);
        });
        // 拼接排序后的单词
        for (String str : strs) {
            res.append(str, 0, str.length() - 1).append(" ");
        }
        // 去末尾空格
        return res.toString().trim();
    }
}
