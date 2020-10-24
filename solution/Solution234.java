package leetcode.solution;


import leetcode.struct.ListNode;

/**
 * 234. 回文链表
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * <p>
 * Solution: 因为单链表只有一个方向，所以我想的是将链表后半部分反转，然后头尾两个指针移动开始比较。
 *
 * @author mingkai
 */
public class Solution234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        int length = 1;
        ListNode p = head;  // p指向尾部
        ListNode mid = head; // mid指向中部
        while (p.next != null) {
            length++;
            if (length % 2 == 0) {
                mid = mid.next;
            }
            p = p.next;
        }

        //反转链表后半部分
        ListNode pre = null;
        ListNode cur = length % 2 == 0 ? mid : mid.next;
        for (int i = 0; i < length >> 1; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        //头尾开始比较
        for (int i = 0; i < length >> 1; i++) {
            System.out.println("p： " + p.val);
            System.out.println("h： " + head.val);
            if (p.val != head.val) {
                return false;
            }
            p = p.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        ListNode a = ListNode.create(1, 2, 1, 2 ,1);
        System.out.println(solution234.isPalindrome(a));

    }


}
