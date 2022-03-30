package Study.剑指Offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description 27
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/22 13:34
 */
public class 二叉树的镜像 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                TreeNode tmp = cur.left;
                cur.left = cur.right;
                cur.right = tmp;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return root;
    }
}
