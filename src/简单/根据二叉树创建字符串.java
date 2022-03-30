package 简单;

import java.util.Stack;

/**
 * @Description 606
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/19 16:00
 */
public class 根据二叉树创建字符串 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
     }

    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        if (root.left == null && root.right == null)
            return Integer.toString(root.val);
        if (root.right == null)
            return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(")").toString();
    }


}
