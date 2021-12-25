package DNA.基础;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/22 16:10
 */
public class Dijkstra {

    public static HashMap<Graph.Node, Integer> dijkstra (Graph.Node head) {
        //key: 从head到key结点
        //value: 从head到key的最小距离
        HashMap<Graph.Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Graph.Node> selectedNodes = new HashSet<>(); //锁上的记录
        Graph.Node minNode = getMinDistanceAndUnselectNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Graph.Edge edge : minNode.edges) {
                Graph.Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) { //未被记录的结点距离为正无穷
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                selectedNodes.add(minNode);
                minNode = getMinDistanceAndUnselectNode(distanceMap, selectedNodes);
            }
        }
        return distanceMap;
    }

    private static Graph.Node getMinDistanceAndUnselectNode(HashMap<Graph.Node, Integer> distanceMap, HashSet<Graph.Node> selectedNodes) {
        Graph.Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry< Graph.Node,  Integer> entry : distanceMap.entrySet()) {
            Graph.Node node = entry.getKey();
            int distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }


    //加速后
    public static class NodeRecord { //记录类
        public Graph.Node node;
        public int distance;

        public NodeRecord(Graph.Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static class NodeHeap {
        private Graph.Node[] nodes;
        private HashMap<Graph.Node, Integer> heapIndexMap; //通过node查询堆的位置
        private HashMap<Graph.Node, Integer> distanceMap; //通过node查询权值
        private int size;

        public NodeHeap(int size) {
            nodes = new Graph.Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        private boolean isEmpty() {
            return this.size == 0;
        }
        private boolean isEntered(Graph.Node node) {
            return heapIndexMap.containsKey(node);
        }
        private boolean inHeap(Graph.Node node) { //进来过且还在堆中
            return isEntered(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Graph.Node tmp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = tmp;
        }
        private void insertHeapify(Graph.Node node, int index) {
            while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index-1) / 2])) {
                swap(index, (index-1) / 2);
                index = (index-1) / 2;
            }
        }
        private void heapify(int index, int size) {
            int left = index * 2 + 1;
            while (left < size) {
                int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left]) ? left + 1 : left;
                smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
                if (smallest == index) {
                    break;
                }
                swap(smallest, index);
                index = smallest;
                left = index * 2 + 1;
            }
        }

        public void addOrUpdateOrIgnore(Graph.Node node, int distance) {
            if (inHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                heapIndexMap.put(node, size);
                distanceMap.put(node, distance);
                insertHeapify(node, size++);
            }
        }
        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            nodes[size - 1] = null; //0和size-1交换
            heapify(0, --size);
            return nodeRecord;
        }
    }

    public static HashMap<Graph.Node, Integer> dijkstra (Graph.Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Graph.Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Graph.Node cur = record.node;
            int distance = record.distance;
            for (Graph.Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }
}
