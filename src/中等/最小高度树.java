package 中等;

import javafx.scene.web.WebHistory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/26 16:19
 */
public class 最小高度树 {

    public static class Edge {
        int value;
        int in;
        Edge next;

        public Edge(int value, int in, Edge next) {
            this.value = value;
            this.in = in;
            this.next = next;
        }
    }

    //拓扑排序：一层一层的删结点，直到最后一层的结点
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> arr = new ArrayList<>();
        Edge[] edgeMap = new Edge[n];
        HashMap<Integer, Integer> tree = new HashMap<>();
        if (n == 0 || edges.length == 0) {
            arr.add(0);
            return arr;
        }
        for (int[] edge : edges) { //将边及出现次数统计
            edgeMap[edge[0]].next = edgeMap[edge[0]];
            edgeMap[edge[1]].next = edgeMap[edge[1]];
            for (int node : edge) {
                edgeMap[node].value = node;
                edgeMap[node].in++;
            }
        }
        Stack<Edge> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(edgeMap[i]);
        }
        return arr;
    }
}
