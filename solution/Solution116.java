package leetcode.solution;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * <p>
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * Solution: 利用辅助函数递归，覆盖全部链接情况，考虑不是同一父节点的情况
 */
public class Solution116 {

    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        margeTwo(root.left, root.right);

        return root;
    }

    /**
     * 讲两个节点相关联
     *
     * @param node1 节点1
     * @param node2 节点2
     */
    private void margeTwo(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;

        margeTwo(node1.left, node1.right); //节点1的左右
        margeTwo(node2.left, node2.right); //节点2的左右

        margeTwo(node1.right, node2.left); //不同父节点的情况
    }


    public static void main(String[] args) {
        Solution116 solution116 = new Solution116();
        Node test = new Node(1);
        test.left = new Node(2);
        test.right = new Node(3);
        test.left.left = new Node(4);
        test.left.right = new Node(5);
        test.right.left = new Node(6);
        test.right.right = new Node(7);

        solution116.connect(test);

        while (test != null) {
            Node tmp = test;
            while (tmp != null) {
                System.out.print(tmp.val);
                tmp = tmp.next;
            }
            System.out.println();
            test = test.left;
        }
    }


}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
