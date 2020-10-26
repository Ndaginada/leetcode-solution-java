package leetcode.solution;

import leetcode.struct.ListNode;

/**
 * 21. 合并两个有序链表
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * Solution: 同时遍历两个链表，比对两个链表的节点值，使新链表指向小的，并向后移动。
 *           如果有一个遍历完，那么新链表后面就是没遍历完的部分。
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode link = new ListNode();

        ListNode heard = link;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) { //l1的值小
                link.next = l1;
                l1 = l1.next;
            } else { //l2的值小
                link.next = l2;
                l2 = l2.next;
            }

            link = link.next;

        }
        link.next = l1 == null ? l2 : l1;


        return heard.next;
    }


    public static void main(String[] args) {
        ListNode a = ListNode.create(1, 2, 4);
        ListNode b = ListNode.create(1, 3, 5);

        Solution21 solution21 = new Solution21();
        solution21.mergeTwoLists(a, b).print();
    }


}
