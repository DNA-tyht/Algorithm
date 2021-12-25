package DNA.基础;

import java.util.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/22 13:41
 */
public class MapErgodic {

    public static void bfs(Graph.Node node) {
        if (node != null) {
            Queue<Graph.Node> queue = new LinkedList<>(); //宽度优先遍历
            HashSet<Graph.Node> set = new HashSet<>(); //去重
            queue.add(node);
            set.add(node);
            while (!queue.isEmpty()) {
                Graph.Node cur = queue.poll();
                System.out.println(cur.value);
                for (Graph.Node next : cur.nexts) {
                    if (!set.contains(next)) {
                        set.add(next);
                        queue.add(next);
                    }
                }
            }
        }
    }

    public static void dfs(Graph.Node node) {
        if (node != null) {
            Stack<Graph.Node> stack = new Stack<>(); //栈保存的是深度优先的路径
            HashSet<Graph.Node> set = new HashSet<>();
            stack.add(node);
            set.add(node);
            System.out.println(node.value);
            if (!stack.isEmpty()) {
                Graph.Node cur = stack.pop();
                for (Graph.Node next : cur.nexts) {
                    if (!set.contains(next)) { //只走没走过的结点
                        stack.push(cur); //重新将cur压入
                        stack.push(next);
                        set.add(next);
                        System.out.println(next.value);
                        break;
                    }
                }
            }
        }
    }

    //拓扑排序
    public static List<Graph.Node> sortedTopology(Graph graph) {
        //key: node, value: 入度
        HashMap<Graph.Node, Integer> inMap = new HashMap<>();
        //入度为0的结点进入队列
        Queue<Graph.Node> zeroInQueue = new LinkedList<>();
        for (Graph.Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        //拓扑排序的结果
        List<Graph.Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Graph.Node cur = zeroInQueue.poll();
            result.add(cur);
            //将加入result的结点剥离map
            for (Graph.Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1); //cur相邻的结点入度-1
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }


}
