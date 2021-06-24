package geeksforgeeks.recurssion;

import geeksforgeeks.tree.TreeNode;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBT {
    private TreeNode prev;
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        root.left = null;

        flatten(left);
        flatten(right);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(1), null);
        TreeNode root = new TreeNode(3, left, new TreeNode(4));

        FlattenBT flattenBT = new FlattenBT();
        flattenBT.flatten(root);
        while(root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }

    }
}
