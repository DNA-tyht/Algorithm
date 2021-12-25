package DNA.基础;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/19 20:43
 */
public class CheckTree {

    public static int preValue = Integer.MIN_VALUE;
    //二叉搜索树
    public static boolean checkBST(Node head) {
        if (head == null) {
            return true;
        }
        if (!checkBST(head.left)) {
            return false;
        } else {
            preValue = head.data;
        }
        return checkBST(head.right);
    }

    public static boolean checkCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false; //是否遇到过左右结点不全的情况
        Node left = null;
        Node right = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            //遇到不双全的结点后，发现该结点不是叶结点
            if ((left == null && right != null) || (leaf && (left == null && right == null))) {
                return false;
            }
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }
    public static class ReturnType {
        public boolean isBalanced;
        public int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public static ReturnType process(Node x) {
        if (x == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = leftData.isBalanced && rightData.isBalanced
                && Math.abs(leftData.height - rightData.height) <= 1;
        return new ReturnType(isBalanced, height);
    }

    public static boolean isBST1(Node head) {
        return process1(head).isBST;
    }
    public static class ReturnData {
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public static ReturnData process1(Node x) {
        if (x == null) {
            return null;
        }
        ReturnData leftData = process1(x.left);
        ReturnData rightData = process1(x.right);
        boolean isBST = true;
        int min = x.data;
        int max = x.data;
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
        }
        if (leftData != null && (!leftData.isBST || leftData.max >= x.data)) {
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= x.data)) {
            isBST = false;
        }
        return new ReturnData(isBST, min, max);
    }

    public static boolean checkFull(Node head) {
        if (head == null) {
            return true;
        }
        Info data = process2(head);
        return data.nodes == Math.pow(2, data.height) - 1;
    }
    public static class Info {
        public int height;
        public int nodes;
        public Info(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }
    public static Info process2(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process2(x.left);
        Info rightInfo = process2(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info(height, nodes);
    }
}
