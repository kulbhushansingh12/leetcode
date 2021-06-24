package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

import geeksforgeeks.tree.TreeNode;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    // Using BFS, level order traversal
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // swap right and left
            TreeNode leftTemp = node.left;
            node.left = node.right;
            node.right = leftTemp;

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
            return null;

        TreeNode leftTemp = root.left;
        root.left = root.right;
        root.right = leftTemp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }
}
