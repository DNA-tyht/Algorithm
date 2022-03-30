package 简单;

/**
 * @Description 167
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 18:03
 */
public class 输入有序数组 {

    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int add = numbers[left] + numbers[right];
            if (add > target) right--;
            else if (add < target) left++;
            else {
                answer[0] = left + 1;
                answer[1] = right + 1;
                return answer;
            }
        }
        return answer;
    }
}
