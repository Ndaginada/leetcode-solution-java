package leetcode.solution;

import leetcode.struct.ListNode;

/**
 * 160. 相交链表
 * <p>
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * Solution: 一开始想到用哈希表，遍历A中每一个放入哈希表，如果B中有相同地址元素就是交点，但是空间复杂度为O(n)
*            参考题解，使用双指针法，相当于将两个链表拼起来分别遍历，两个指针相遇就是交点，比如：
*            两个链表 1-2-3-4-5 和  8-9-4-5
*            1-2-3-4-5-null-8-9-4-5-null
*            8-9-4-5-null-1-2-3-4-5-null
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.create(2);
        ListNode ah = a;
        ListNode b = ListNode.create(7, 6);
        ListNode bh = b;
        ListNode c = ListNode.create(1, 2);
        while (a.next != null) {
            a = a.next;
        }
        while (b.next != null) {
            b = b.next;
        }
        a.next = c;
        b.next = c;

        Solution160 solution160 = new Solution160();

        solution160.getIntersectionNode(ah, bh).print();
    }
}
