package DNA.基础;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/10/9 20:19
 */
public class BitOperation {

    public static int[] arr1 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
    public static int[] arr2 = {1, 2, 3, 4, 5, 6, 4, 3, 2, 1};

    public static void printOddTimeNum1() {
        int num = 0;
        for (int i = 0; i < arr1.length; i++) {
            num ^= arr1[i];
        }
        System.out.println("num: " + num);
    }

    public static void printOddTimeNum2() {
        int num1 = 0, num2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            num1 ^= arr2[i];
        }
        //num1 != 0，则num必然有一位为1
        int rightOne = num1 & (~num1 + 1); //取出最右端的1
        for (int i = 0; i < arr2.length; i++) {
            if ((arr2[i] & rightOne) == 0) {
                num2 ^= arr2[i];
            }
        }
        num1 ^= num2;
        System.out.println("num1: " + num1 + ", num2: " + num2);
    }

    public static void main(String[] args) {
        printOddTimeNum1();
        printOddTimeNum2();
    }
}
