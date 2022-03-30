package Study.剑指Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 26
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/3/22 13:11
 */
public class 树的子结构 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        //Queue<TreeNode> queue = new LinkedList<>();
        //queue.add(A);
        //while (!queue.isEmpty()) {
        //     A = queue.poll();
        //    if (A.val == B.val)
        //        return recur(A, B); //val可能重复
        //    if (A.left != null) queue.add(A.left);
        //    if (A.right != null) queue.add(A.right);
        //}
        //return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right);
    }
}
