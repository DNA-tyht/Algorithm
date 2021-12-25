package DNA.基础;

import java.util.Arrays;

/**
 * @Description 排序算法
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/10/9 19:10
 */
public class Sort {

    /**
    * @Description 选择排序：O(n^2)
    * @Return
    * @Author 脱氧核糖
    * @Date 2021/10/9 19:11
    */
    public static void selectionSort(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    //将i后最小的数与i交换
                    minIndex = arr[j] < arr[minIndex] ? j : minIndex;
                }
                swap(arr, i, minIndex);
            }
        }
    }
    /**
    * @Description 冒泡排序：O(N^2)
    * @Return [arr]
    * @Author 脱氧核糖
    * @Date 2021/10/9 19:20
    */
    public static void bubbleSort(int[] arr) {
        if (arr != null && arr.length > 1) {
            //每一轮：0-n，0-n-1，0-n-2……
            for (int i = arr.length - 1; i > 0 ; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] > arr[j + 1])
                        swap(arr, j, j + 1);
                }
            }
        }
    }
    /**
    * @Description 插入排序：O(N^2)（最差情况）
    * @Return [arr, i, j]
    * @Author 脱氧核糖
    * @Date 2021/10/9 20:47
    */
    public static void insertSort(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 1; i < arr.length; i++) { //0-1范围内有序
                for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--)
                    swap(arr, j, j + 1); //当前数往左排序直到排好
            }
        }
    }
    /**
    * @Description 归并排序：O(log2N)
    * @Return [arr]
    * @Author 脱氧核糖
    * @Date 2021/10/10 15:02
    */
    //归并排序的优点是没有浪费每一次比较，每次比较的行为信息都被存储为有序的数组
    //在在下一次与更大范围的数组归并
    public static void mergeSort(int[] arr) {
        if (arr != null && arr.length > 1) {
            process(arr, 0, arr.length - 1);
        }
    }
    public static void process(int[] arr, int L, int R) {
        if (L == R)
            return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0, p1 = L, p2 = M + 1;
        while (p1 <= M && p2 <= R)
            help[i++] = arr[p1]  < arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= M)
            help[i++] = arr[p1++];
        while (p2 <= R)
            help[i++] = arr[p2++];
        for (i = 0; i < help.length; i++)
            arr[L + i] = help[i];
    }
    /**
    * @Description 快速排序：O(N * log2 N)
    * @Return [arr, i, j]
    * @Author 脱氧核糖
    * @Date 2021/10/11 13:21
    */
    public static void quickSort(int[] arr) {
        if (arr != null && arr.length > 1) {
            quickSort(arr, 0, arr.length - 1);
        }
    }
    public static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            //生成随机数位置与最后一个数交换
            swap(arr, (int)(Math.random() * (R - L + 1)), R);
            int[] p = partiton(arr, L, R);
            quickSort(arr, L, p[0] - 1); //小于区
            quickSort(arr, p[1] + 1, R); //大于区
        }
    }
    //返回值为左边界和有边界的位置
    public static int[] partiton(int[] arr, int L, int R) {
        int less = L - 1; //小于区右边界
        int more = R; //大于区左边界
        while (L < more) {//L代表当前数位置
            if (arr[L] < arr[R]) {
                swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[] {less + 1,  more};
    }
    /**
    * @Description 堆排序：O(N * log2 N)
    * @Return [arr, index]
    * @Author 脱氧核糖
    * @Date 2021/10/14 16:46
    */
    public static void heapInsert(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 0; i < arr.length; i++) { //将数组排成大根堆
                heapInsert(arr, i);
            }
            int heapSize = arr.length;
            swap(arr, 0, --heapSize);
            while (heapSize > 0) {
                heapify(arr, 0, heapSize);
                swap(arr, 0, --heapSize);
            }
        }
    }
    //结点往上升
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    //结点往下沉
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; //左孩子
        while (left < heapSize) { //下方还有孩子
            //左孩子和右孩子比较
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //父亲和孩子比较
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break; //头结点就是最大值
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
    /**
    * @Description 桶排序
    * @Return
    * @Author 脱氧核糖
    * @Date 2021/11/17 19:21
    */
    public static void radixSort(int[] arr) {
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }
    //统计有多少位
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        //准备辅助空间
        int[] bucket = new int[R - L + 1];
        for (int d = 0; d < digit; d++) {
            int[] count = new int[radix]; //词频统计
            for (i = L; i <= R; i++) { //每轮比较的词频统计
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] += count[i-1];
            }
            for (i = R; i >= L; i--) { //出桶
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
    /**
    * @Description 交换方法
    * @Return [arr, i, j]
    * @Author 脱氧核糖
    * @Date 2021/10/10 13:55
    */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int testTims = 10000; //测试次数
        int maxSize = 20; //最大测试容量
        int maxNum = 20; //最大测试数据
        boolean euqals = true;
        for (int i = 0; i < testTims; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxNum);
            int[] arr2 = copyArray(arr1); //这两个数组除了数值相同，内存地址完全没关系
            mergeSort(arr1); //自己的算法排序
            Arrays.sort(arr2); //java.util.Arrays包的排序算法排序
            if (!isEquals(arr1,arr2)) { //比较是否相同
                euqals = false; //一旦有不一样的值就设为false;
                break;
            }
        }
        System.out.println(euqals ? "Success:恭喜你！没毛病！" : "Error：抱歉，有错误" );
        int[] newArr = generateRandomArray(maxSize, maxNum);
        printArray(newArr);//没排序的数组打印出来
        bubbleSort(newArr);
        printArray(newArr);//再次打印
    }
    /**
    * @Description 随机生成数组
    * @Return [maxSize, maxValue]
    * @Author 脱氧核糖
    * @Date 2021/10/10 13:51
    */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())]; //长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random()); //数值随机
        }
        return arr;
    }
    /**
    * @Description 复制当前数组的一个样本
    * @Return [arr]
    * @Author 脱氧核糖
    * @Date 2021/10/10 14:00
    */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }
    /**
    * @Description 判断两个数组是否完全相同
    * @Return [arr1, arr2]
    * @Author 脱氧核糖
    * @Date 2021/10/10 14:00
    */
    public static boolean isEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        if (arr1 != null && arr2 == null || arr1 == null && arr2 != null) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        return true;
    }
    /**
    * @Description 打印数组
    * @Return [arr]
    * @Author 脱氧核糖
    * @Date 2021/10/10 14:01
    */
    public static void printArray(int[] arr) {
        if(arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
