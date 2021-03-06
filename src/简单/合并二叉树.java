package 简单;

import java.util.Stack;

/**
 * @Description 617
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2022/1/26 14:57
 */
public class 合并二叉树 {

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

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
         if (root1 == null)
             return root2;
         if (root2 == null)
             return root1;
         root1.val += root2.val;
         root1.left = mergeTrees(root1.left, root2.left);
         root1.right = mergeTrees(root1.right, root2.right);
         return root1;
    }
}
