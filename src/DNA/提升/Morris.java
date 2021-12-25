package DNA.提升;

import DNA.基础.Node;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/11 18:19
 */
public class Morris {

    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { //有左子树
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                } //mostRight变成左子树上最右的结点
                if (mostRight.right == null) { //第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null; //恢复指针
                }
            }
            cur = cur.right;
            int $abc = 0;
        }
    }

}
