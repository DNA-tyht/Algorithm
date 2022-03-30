package 困难;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 432
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/16 15:52
 */
public class 全O1的数据结构 {

    class AllOne {

        private HashMap<String, Node> nodes;
        private Node root;

        class Node {
            private Node pre;
            private Node next;
            private int count;
            private Set<String> key;

            public Node() {
            }

            public Node(String key, int count) {
                this.key = new HashSet<>();
                this.key.add(key);
                this.count = count;
            }

            public void insert(Node node) { //在this后插入
                node.pre = this;
                node.next = this.next;
                node.pre.next = node;
                node.next.pre = node;
            }
            public void delete() { //删除this
                this.pre.next = this.next;
                this.next.pre = this.pre;
            }
        }

        public AllOne() {
            nodes = new HashMap<>();
            root = new Node();
            root.pre = root;
            root.next = root;
        }

        public void inc(String key) {
            if (nodes.get(key) != null) {
                Node cur = nodes.get(key);
                Node next = cur.next;
                if (next == root || next.count > cur.count + 1)
                    nodes.put(key, new Node(key, cur.count + 1));
                else {
                    next.key.add(key);
                    nodes.put(key, next);
                }
                cur.key.remove(key);
                if (cur.key.isEmpty())
                    cur.delete();
            } else {
                if (root.next == root || root.next.count > 1) {
                    Node node = new Node(key, 1);
                    root.insert(node);
                    nodes.put(key, node);
                } else {
                    root.next.key.add(key);
                    nodes.put(key, root.next);
                }
            }
        }

        public void dec(String key) {
            Node cur = nodes.get(key);
            if (cur.count == 1) {
                nodes.remove(key);
            } else {
                Node pre = cur.pre;
                if (pre == root || pre.count < cur.count - 1) {
                    Node node = new Node(key, cur.count - 1);
                    cur.pre.insert(node);
                    nodes.put(key, cur);
                } else {
                    pre.key.add(key);
                    nodes.put(key, pre);
                }
            }
            cur.key.remove(key);
            if (cur.key.isEmpty())
                cur.delete();
        }

        public String getMaxKey() {
            return root.pre != null ? root.pre.key.iterator().next() : "";
        }

        public String getMinKey() {
            return root.next != null ? root.next.key.iterator().next() : "";
        }
    }
}
