package DNA.基础;

/**
 * @Description 将单向链表按某值划分成左边小、中间相等、右边大的形式
 * @Author 脱氧核糖
 * @Version 1.0
 * @Date 2021/11/18 15:45
 */
public class ListPartition {

    public static Node listPartition(Node head, int pivot) {
        Node sh = null; //小于区头
        Node st = null; //小于区尾
        Node eh = null; //等于区头
        Node et = null; //等于区尾
        Node mh = null; //大于区头
        Node mt = null; //大于区尾
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.data < pivot) {
                if (sh == null) {
                    sh = head;
                    st = head;
                } else {
                    st.next = head;
                    st = head;
                }
            } else if (head.data == pivot) {
                if (eh == null) {
                    eh = head;
                    et = head;
                } else {
                    et.next = head;
                    et = head;
                }
            } else {
                if (mh == null) {
                    mh = head;
                    mt = head;
                } else {
                    mt.next = head;
                    mt = head;
                }
            }
            head = next;
        }
        //开始拼接
        if (st != null) {
            st.next = eh;
            et = et == null ? st : et; //连接下个区域的头
        }
        if (et != null) {
            et.next = mh;
        }
        return sh != null ? sh: (eh != null ? eh : mh);
    }
}
