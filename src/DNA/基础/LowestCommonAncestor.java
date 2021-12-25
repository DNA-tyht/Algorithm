package DNA.基础;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/20 14:55
 */
public class LowestCommonAncestor {

    public static Node lowestCommonAncestor(Node head, Node o1, Node o2) {
        //记录每个结点的父结点
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set1 = new HashSet<>();
        HashSet<Node> set2 = new HashSet<>();
        Node cur = o1;
        while (cur != fatherMap.get(cur)) { //生成o1的回溯链
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(head);
        cur = o2;
        while (cur != fatherMap.get(cur)) { //生成o2的回溯链
            set2.add(cur);
            cur = fatherMap.get(cur);
        }
        set2.add(head);
        Iterator<Node> iterator = set1.iterator();
        while (iterator.hasNext()) {
            if (set2.equals(iterator.next())) {
                return iterator.next();
            }
        }
        return head;
    }

    //存储所有结点的父结点
    public static void process(Node head, HashMap<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }
}
