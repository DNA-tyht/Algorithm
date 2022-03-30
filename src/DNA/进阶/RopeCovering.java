package DNA.进阶;

import java.util.Arrays;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 10:45
 */
public class RopeCovering {

    public  static int ropeCovering(int[] arr, int length) {
        if (arr.length == 0 || length <= 0)
            return 0;
        int left = 0, right; //开始和起始指针
        int max = 0;
        for (right = 0; right < arr.length; right++) {
            while (arr[right] - arr[left] > length)
                left++;
            if (right - left + 1 > max)
                max = right - left + 1;
        }
        return max;
    }

    //对照组
    public static int getMaxNode(int[] arr,int L){
        if(arr==null||L<1){
            return 0;
        }
        int max=1;
        //滑动窗口左边界
        int leftNum=0;
        //滑动窗口右边界
        int rightNum=1;
        int left;
        int right;
        while(rightNum!=arr.length){
            left=arr[leftNum];
            right=arr[rightNum];
            if(right-left<=L){
                //没有超过窗口，右边界右移一位
                rightNum++;
            }else {
                if(max<rightNum-leftNum){
                    max=rightNum-leftNum;
                }
                //左边界右移一位
                leftNum++;
            }
        }
        if(max<rightNum-leftNum){
            max=rightNum-leftNum;
        }
        return max;
    }

    public static void main(String[] args) {
        int testTims = 10000; //测试次数
        int maxSize = 20; //最大测试容量
        int maxNum = 20; //最大测试数据
        boolean euqals = true;
        for (int i = 0; i < testTims; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxNum);
            int[] arr2 = copyArray(arr1); //这两个数组除了数值相同，内存地址完全没关系
            if (getMaxNode(arr1, 10) != ropeCovering(arr2, 10)) { //比较是否相同
                euqals = false; //一旦有不一样的值就设为false;
                break;
            } else
                System.out.println("dui");
        }
        System.out.println(euqals ? "Success:恭喜你！没毛病！" : "Error：抱歉，有错误" );
    }
    //随机生成数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())]; //长度随机
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random()); //数值随机
        return arr;
    }
    //复制当前数组的一个样本
    public static int[] copyArray(int[] arr) {
        if (arr == null)
            return null;
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            newArray[i] = arr[i];
        return newArray;
    }
}
