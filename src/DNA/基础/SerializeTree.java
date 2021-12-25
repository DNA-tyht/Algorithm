package DNA.基础;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/20 16:06
 */
public class SerializeTree {

    //将树序列化为字符串
    public static String serialByPre(Node head) {
        if (head == null) {
            return "#_";
        }
        String res = head.data + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    //将字符串反序列化为树
    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
