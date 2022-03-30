package DNA.进阶;

import java.util.HashMap;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/29 9:19
 */
public class TopKTimes {
    public static class Node {
        public String str;
        public int times;

        public Node(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }
    public static class TopKRecord {
        private Node[] heap;
        private int index;
        private HashMap<String, Node> stringNodeMap;
        private HashMap<Node, Integer> nodeIntegerMap;

        public TopKRecord(int size) {
            this.heap = new Node[size];
            index = 0;
            stringNodeMap = new HashMap<>();
            nodeIntegerMap = new HashMap<>();
        }

        private void add (String str) {
            Node curNode = null;
            int preIndex = -1;
            if (!stringNodeMap.containsValue(str)) { //str第一次出现
                curNode = new Node(str, 1);
                stringNodeMap.put(str, curNode);
            } else { //str非第一次出现
                curNode = stringNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIntegerMap.get(curNode);
            }
            if (preIndex == -1) { //str不在堆上的
                if (index == heap.length) { //堆满了
                    if (heap[0].times < curNode.times) { //比堆顶大进入堆
                        nodeIntegerMap.put(heap[0], -1);
                        nodeIntegerMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify(0, index);
                    }
                } else { //堆没满
                    nodeIntegerMap.put(curNode, index);
                    heap[index] = curNode;
                    heapInsert(index++);
                }
            } else { //str在堆上
                heapify(preIndex, index);
            }
        }

        private void heapInsert(int index) {
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[index].times < heap[parent].times) {
                    swap(parent, index);
                    index = parent;
                } else
                    break;
            }
        }

        private void swap(int a, int b) {
            nodeIntegerMap.put(heap[a], b);
            nodeIntegerMap.put(heap[b], a);
            Node tmp = heap[a];
            heap[a] = heap[b];
            heap[b] = tmp;
        }

        private void heapify(int index, int heapSize) {

        }
    }
}
