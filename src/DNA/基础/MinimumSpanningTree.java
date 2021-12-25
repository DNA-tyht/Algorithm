package DNA.基础;

import java.util.*;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/22 16:09
 */
public class MinimumSpanningTree {

    //最小生成树
    public static class MySets {
        //一个点对应一个集合
        public HashMap<Graph.Node, List<Graph.Node>> setMap;
        public MySets(List<Graph.Node> nodes) {
            for (Graph.Node cur : nodes) {
                List<Graph.Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set); //初始时，每个结点都对应一个集合
            }
        }
        //判断两个结点是否属于一个集合
        public boolean isSameSet(Graph.Node from, Graph.Node to) {
            List<Graph.Node> fromSet = setMap.get(from);
            List<Graph.Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }
        //结点合并集合
        public void union(Graph.Node from, Graph.Node to) {
            List<Graph.Node> fromSet = setMap.get(from);
            List<Graph.Node> toSet = setMap.get(to);
            for (Graph.Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    public static Set<Graph.Edge> primMST(Graph graph) {
        //解锁的边进入优先级队列
        PriorityQueue<Graph.Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Graph.Node> set = new HashSet<>();
        Set<Graph.Edge> result = new HashSet<>();
        for (Graph.Node node : graph.nodes.values()) { //处理森林问题，确定图是连通的可以去掉
            if (!set.contains(node)) {
                set.add(node);
                for (Graph.Edge edge : node.edges) { //存储结点所有的边
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Graph.Edge edge = priorityQueue.poll(); //弹出最小边
                    Graph.Node toNode = edge.to;
                    if (!set.contains(toNode)) { //到达新的点
                        set.add(toNode);
                        result.add(edge);
                        for (Graph.Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static class EdgeComparator implements Comparator<Graph.Edge> {
        @Override
        public int compare(Graph.Edge o1, Graph.Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}
