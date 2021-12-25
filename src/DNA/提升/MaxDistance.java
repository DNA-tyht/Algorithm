package DNA.提升;

import DNA.基础.Node;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/12/10 18:40
 */
public class MaxDistance {

    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

    private static Info process(Node x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + 1 + rightInfo.height;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int maxDistance = Math.max(p3, Math.max(p1, p2));
        return new Info(maxDistance, height);
    }
}
