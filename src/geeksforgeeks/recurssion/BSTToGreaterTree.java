package geeksforgeeks.recurssion;

import geeksforgeeks.tree.TreeNode;

// https://leetcode.com/problems/convert-bst-to-greater-tree/
public class BSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        convertBSTHelper(root, 0);
        return root;
    }

    public int convertBSTHelper(TreeNode node, int sum) {
        if (node == null)
            return sum;

        node.val = node.val + convertBSTHelper(node.right, sum);
        return convertBSTHelper(node.left, node.val);
    }

    public static void main(String[] args) {
        BSTToGreaterTree tree = new BSTToGreaterTree();
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(7));
        tree.convertBST(root);
    }
}
