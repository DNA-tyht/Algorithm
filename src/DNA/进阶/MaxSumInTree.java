package DNA.进阶;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/28 8:58
 */
public class MaxSumInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int maxSum = Integer.MIN_VALUE; //只在到达叶节点时更新

    public static int maxPath(Node head) {
        process(head, 0);
        return maxSum;
    }

    private static void process(Node node, int pre) {
        if (node.left == null && node.right == null)
            maxSum = Math.max(maxSum, pre + node.value);
        if (node.left != null)
            process(node.left, pre + node.value);
        if (node.right != null)
            process(node.right, pre + node.value);
    }
}
