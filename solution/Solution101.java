package leetcode.solution;

import leetcode.struct.TreeNode;

/**
 * 101. 对称二叉树
 * <p>
 * https://leetcode-cn.com/problems/symmetric-tree/
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。 
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3 4 4  3
 *
 * <p>
 * Solution: 对称的话有 left.left = right.right && left.right = right.left，
 *           递归遍历去判断
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        return check(node1.left, node2.right) && check(node1.right, node2.left);
    }


    public static void main(String[] args) {

        Solution101 solution101 = new Solution101();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        System.out.println(solution101.isSymmetric(root));

    }


}
