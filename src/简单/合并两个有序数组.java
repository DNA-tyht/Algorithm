package 简单;

/**
 * @Description 88
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/18 11:56
 */
public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        int[] res = new int[m + n];
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j])
                res[index++] = nums1[i++];
            else
                res[index++] = nums2[j++];
        }
        while (i < m)
            res[index++] = nums1[i++];
        while (j < n)
            res[index++] = nums2[j++];
        for (int k = 0; k < res.length; k++) {
            nums1[k] = res[k];
        }
    }
}
