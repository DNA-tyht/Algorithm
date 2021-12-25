package DNA.提升;

import java.util.LinkedList;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/3 14:41
 */
public class getMaxWindow {

    public static class WindowMax {
        private int L;
        private int R;
        private int[] arr;
        private LinkedList<Integer> max;

        public WindowMax(int[] arr) {
            L = -1;
            R = 0;
            this.arr = arr;
            this.max = new LinkedList<>();
        }

        public void addNumFromRight() {
            if (R == arr.length) {
                return;
            }
            while (!max.isEmpty() && arr[max.peekLast()] <= arr[R]) {
                max.pollLast();
            }
            max.addLast(R);
            R++;
        }
        public void removeNumFromLeft() {
            if (L >= R - 1) {
                return;
            }
            L++;
            if (max.peekFirst() == L) {
                max.pollFirst();
            }
        }
        public Integer getMax() {
            if (!max.isEmpty()) {
                return arr[max.peekFirst()];
            }
            return null;
        }
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> max = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!max.isEmpty() && arr[max.peekLast()] <= arr[i]) {
                max.pollLast();
            }
            max.addLast(i);
            if (max.peekFirst() == i - w) {
                max.pollFirst();
            }
            if (i >= w -1) { //窗口已经形成
                res[index++] = arr[max.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        for (Integer x : getMaxWindow(arr, 3)) {
            System.out.print(x);
        }
    }
}
