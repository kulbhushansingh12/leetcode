package geeksforgeeks.recurssion;

import com.sun.source.tree.Tree;
import geeksforgeeks.tree.TreeNode;

// https://leetcode.com/problems/binary-tree-tilt/
public class LC563BinaryTreeTilt {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        tiltHelper(root);
        return tilt;
    }

    private int tiltHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeSum = 0;
        if (root.left != null) {
            leftTreeSum = root.left.val + tiltHelper(root.left);
        }

        int rightTreeSum = 0;
        if (root.right != null) {
            rightTreeSum = root.right.val + tiltHelper(root.right);
        }

        tilt += Math.abs(leftTreeSum - rightTreeSum);

        return leftTreeSum + rightTreeSum;
    }

    public static void main(String[] args) {
        LC563BinaryTreeTilt binaryTreeTilt = new LC563BinaryTreeTilt();
        TreeNode leftNode = new TreeNode(2, new TreeNode(3), new TreeNode(5));
        TreeNode right = new TreeNode(9, null, new TreeNode(7));
        TreeNode root = new TreeNode(4, leftNode, right);
        binaryTreeTilt.findTilt(root);
        System.out.println(binaryTreeTilt.tilt);
    }
}
