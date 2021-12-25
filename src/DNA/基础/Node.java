package DNA.基础;

/**
 * @Description
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/18 16:09
 */
//定义一个节点类
public class Node{
    public int data;
    //链表
    public Node next;
    //带随机指针的链表
    public Node rand;
    //二叉树
    public Node left;
    public Node right;
    //带父指针的二叉树
    public Node parent;

    public Node(int data, Node next, Node rand, Node left, Node right, Node parent) {
        this.data = data;
        this.next = next;
        this.rand = rand;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public Node(int data, Node next, Node rand, Node left, Node right) {
        this.data = data;
        this.next = next;
        this.rand = rand;
        this.left = left;
        this.right = right;
    }

    public Node(int data, Node next, Node rand){
        this.data = data;
        this.next = next;
        this.rand = rand;
    }
    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    public Node(int data){
        this.data = data;
    }

}