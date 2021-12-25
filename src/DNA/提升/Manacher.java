package DNA.提升;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/2 14:38
 */
public class Manacher {

    public static int Manacher(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length]; //回文半径数组
        int C = -1; //回文中心
        int R = -1; //回文右边界再右边界的位置
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != str.length; i++) { //求每个位置的回文半径
            //i在R内：取2 3情况最小的那个范围
            //i在R外：回文半径暂定为1
            //确定至少不用验证的区域
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            //不需要扩张的过程第一轮就会break
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]])
                    pArr[i]++;
                else
                    break;
            }
            if (i + pArr[i] > R) { //修改信息
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    //处理字符串为带#的字符串
    public static char[] manacherString(String s) {
        char[] charArr = s.toCharArray();
        char[] res = new char[s.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = i % 2 == 0 ? '#' : charArr[index++];
        }
        return res;
    }
}
