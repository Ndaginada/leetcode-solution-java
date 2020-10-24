package leetcode.struct;

public class ListNode {
    public ListNode next;

    public int val;

    public ListNode() {
    }

    public ListNode(int val){
        this.val = val;
    }

    //控制台输出链表内容
    public void print(){
        System.out.println(val);
        while (next != null) {
            System.out.println(next.val);
            next = next.next;
        }
    }

    //快速创建一个链表
    public static ListNode create(int... a){
        if (a.length < 1) {
            return null;
        }
        ListNode head = new ListNode(a[0]);
        ListNode p = head;
        for (int i = 1; i < a.length; i++) {
            head.next = new ListNode(a[i]);
            head = head.next;
        }

        return p;
    }


}
