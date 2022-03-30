package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 14:50
 */
public class EatGrass {

    public static String winner1(int n) {
        //0  1  2  3  4
        //后 先 后 先 先
        if (n < 5)
            return (n == 0 || n == 2) ? "后手" : "先手";
        int base = 1; //先手决定吃草的份数
        while (base <= n) { //先手吃的草有问题
            //母过程中是先手，子过程中是后手
            if (winner1(n - base).equals("后手"))
                return "先手";
            if (base > n/4)
                break;
            base *= 4;
        }
        return "后手";
    }

    public static String winner(int n) {
        if (n % 5 == 0 || n % 5 == 2)
            return "后手";
        else
            return "先手";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) { //规律：后 先 后 先 先
            System.out.println(i + ": " + winner1(i));
        }
    }
}
