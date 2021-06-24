package geeksforgeeks.recurssion;

import geeksforgeeks.tree.TreeNode;

//https://leetcode.com/problems/increasing-order-search-tree
public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }

    public static void main(String[] args) {
        IncreasingBST increasingBST = new IncreasingBST();
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(7));
        increasingBST.increasingBST(root);
    }
}
