package leetcode.solution;

import leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * Solution： 二叉树中序遍历的顺序：左 中 右
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        getNum(root, res);

        return res;
    }

    private void getNum(TreeNode root, List<Integer> res) {
        if (root == null) return;

        getNum(root.left, res);

        res.add(root.val);

        getNum(root.right, res);

    }

    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();

        TreeNode rootr = new TreeNode(1);
        rootr.left = new TreeNode(4);
        rootr.right = new TreeNode(2);
        rootr.right.left = new TreeNode(3);
        solution94.inorderTraversal(rootr).forEach(System.out::println);

    }


}
