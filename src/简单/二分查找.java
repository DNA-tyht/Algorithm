package 简单;

/**
 * @Description 704
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/16 14:23
 */
public class 二分查找 {

    public static int search(int[] nums, int target) {

        int index = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int x = left + (right - left)/2;
            if (nums[x] == target) {
                index = x;
                break;
            } else if (nums[x] < target) {
                left = x + 1;
            } else {
                right = x - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
