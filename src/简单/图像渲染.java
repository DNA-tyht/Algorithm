package 简单;

/**
 * @Description 733
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/26 14:20
 */
public class 图像渲染 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return process(image, sr, sc, newColor, image[sr][sc]);
    }

    private int[][] process(int[][] image, int i, int j, int newColor, int num) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor || image[i][j] != num) {

        } else {
            int tmp = image[i][j];
            image[i][j] = newColor;
            process(image, i + 1, j, newColor, tmp);
            process(image, i - 1, j, newColor, tmp);
            process(image, i, j + 1, newColor, tmp);
            process(image, i, j - 1, newColor, tmp);
        }
        return image;
    }
}
