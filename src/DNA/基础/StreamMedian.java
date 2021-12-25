package DNA.基础;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/26 12:58
 */
class StreamMedian {
    public static class MedianHolder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianHolder() {
            this.minHeap = new PriorityQueue<Integer>();
            this.maxHeap = new PriorityQueue<Integer>(new MaxComparator());
        }

        // 输入数据
        public void input(int i) {
            // 向大根堆放数据,当大根堆为空的时候直接往里放数据，当当前数据小于等于大根堆中元素时候，也放入大根堆。否则放入小根堆。然后调整两个堆中元素数量
            if (maxHeap.isEmpty() || maxHeap.peek() >= i) {
                maxHeap.add(i);
            } else {
                minHeap.add(i);
            }
            modifyTwoHeaps();
        }

        // 两个堆内数据变化后就需要调整堆
        private void modifyTwoHeaps() {
            while (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                } else {
                    minHeap.add(maxHeap.poll());
                }
            }
        }

        // 获得已经输出流的中位数
        public Integer getMedian() {
            if (minHeap.size() + maxHeap.size() == 0) {
                return null;
            }
            if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek();
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return (maxHeap.peek() + minHeap.peek()) / 2;
            }
        }

    }

    public static class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}