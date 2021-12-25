package DNA.基础;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/21 16:35
 */
public class Graph {

    public static class Node {
        public int value;
        public int in; //入度
        public int out; //出度
        public ArrayList<Node> nexts; //该结点相邻的结点
        public ArrayList<Edge> edges; //属于该结点的边
    }
    public static class Edge {
        public int weight; //边的长度
        public Node from;
        public Node to;
    }

    public HashMap<Integer, Node> nodes; //点集
    public HashSet<Edge> edges; //边集

    public Graph(HashMap<Integer, Node> nodes, HashSet<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}
