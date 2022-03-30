package 中等;

/**
 * @Description 2120
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/29 15:31
 */
public class 执行所有后缀指令 {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) { //指令开始
            int x = startPos[0], y = startPos[1];
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'R')
                    y++;
                else if (s.charAt(j) == 'L')
                    y--;
                else if (s.charAt(j) == 'U')
                    x--;
                else if (s.charAt(j) == 'D')
                    x++;
                if (x > n - 1 || x < 0 || y > n - 1 || y < 0)
                    break;
                result[i]++;
            }
        }
        return result;
    }
}
