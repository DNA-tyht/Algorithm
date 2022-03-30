package 中等;

/**
 * @Description 2038
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/22 14:53
 */
public class 如果相邻两个颜色均相同则删除当前颜色 {

    public boolean winnerOfGame(String colors) {
        int count = 0;
        for (int i = 0; i < colors.length() - 2; i++) {
            if (colors.substring(i, i + 3).equals("AAA")) count++;
            if (colors.substring(i, i + 3).equals("BBB")) count--;
        }
        return count > 0;
    }
}
