package 简单;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/29 14:43
 */
public class 翻转图像 {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length, length = image[0].length - 1;
        for (int i = 0; i < n; i++) {
            int left = 0, right = length;
            while (left < right) {
                if ((image[i][left] ^ image[i][right]) == 1) {
                    image[i][left] ^= 1;
                    image[i][right] ^= 1;
                }
                image[i][left] ^= 1;
                image[i][right] ^= 1;
                left++;
                right--;
            }
            if (left == right)
                image[i][left] ^= 1;
        }
        return image;
    }
}
