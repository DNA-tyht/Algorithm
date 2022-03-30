package 简单;

/**
 * @Description 1217
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 15:29
 */
public class 玩筹码 {

    //移动偶数个不花费代价，移动奇数位花费代价
    //将所有的奇数位移动到一起，将所有的偶数位移动到一起
    //最后将少的移动到多的上
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 ==0)
                odd++;
        }
        return Math.min((position.length - odd), odd);
    }
}
