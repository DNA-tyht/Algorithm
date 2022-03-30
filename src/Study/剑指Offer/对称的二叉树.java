package Study.剑指Offer;

/**
 * @Description 28
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/22 14:22
 */
public class 对称的二叉树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && process(left.left, right.right) && process(left.right, right.left);
    }
}
