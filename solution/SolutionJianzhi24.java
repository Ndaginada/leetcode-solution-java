package leetcode.solution;

import leetcode.struct.ListNode;

/**
 * 剑指 Offer 24. 反转链表
 * <p>
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * Solution: 设置两个指针，每次后指针指向前指针，然后移动两个指针，以后指针为空作为判断条件。
 * <p>
 * ps：注意初始前指针不能指向后指针，以防出现环。
 *
 * @author mingkai
 */
public class SolutionJianzhi24 {

    public ListNode reverseList(ListNode head) {

        //前指针
        ListNode p = null;
        //后指针
        ListNode q = head;
        while (q != null) {
            ListNode n = q.next;
            q.next = p;
            //前指针移动
            p = q;
            //后指针移动
            q = n;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.create(1, 2, 3, 4, 5);

        SolutionJianzhi24 solutionJianzhi24 = new SolutionJianzhi24();
        solutionJianzhi24.reverseList(a).print();


    }

}
