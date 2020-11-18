package leetcode.solution;


import leetcode.struct.TreeNode;

/**
 * 543. 二叉树的直径
 * <p>
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * <p>。
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4  5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * <p>
 * Solution: 直径长度最大距离 左右和距离取最大的，注意可以不经过根节点
 */
public class Solution543 {

    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;

        getMaxDept(root);
        return res - 1;
    }

    public int getMaxDept(TreeNode node) {
        if (node == null) return 0;
        int l = getMaxDept(node.left);
        int r = getMaxDept(node.right);
        res = Math.max(res, l + r + 1);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.right.right = new TreeNode(5);
        //treeNode.right = new TreeNode(3);

        Solution543 solution543 = new Solution543();
        System.out.println(solution543.diameterOfBinaryTree(treeNode));

    }

}
