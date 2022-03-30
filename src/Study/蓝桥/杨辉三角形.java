package Study.蓝桥;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/25 13:34
 */
public class 杨辉三角形 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //long n = scanner.nextLong();
        long n = 6;
        int i = 0, j;
        List<BigInteger> ints = new ArrayList<>();
        int level = 1;
        while (true) {
            j = 0;
            while (j < level) {
                if (j == 0 || j == level - 1)
                    ints.add(new BigInteger(String.valueOf(1)));
                else
                    ints.add(ints.get(i - level).add(ints.get(i - level + 1)));
                System.out.println(ints.get(i));
                i++;
                j++;
            }
            level++;
        }
    }
}
