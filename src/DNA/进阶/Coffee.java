package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/30 9:32
 */
public class Coffee {

    public static int process(int[] drinks, int a, int b, int index, int washLine) {
        if (index == drinks.length - 1)
            return Math.min(Math.max(washLine, drinks[index]) + a, drinks[index] + b);
        int wash = Math.max(washLine, drinks[index]) + a; //使用机器洗完当先杯子的时间
        int next1 = process(drinks, a, b, index + 1, wash); //使用机器洗，洗完剩下咖啡杯的最早结束时间
        int p1 = Math.max(wash, next1); //若挥发的比洗的快
        int dry = drinks[index] + b; //使用挥发洗完当前杯子的时间
        int next2 = process(drinks, a, b, index + 1, washLine); //使用挥发洗，洗完剩下咖啡杯的最早结束时间
        int p2 = Math.max(dry, next2);
        return Math.min(p1, p2);
    }
}
