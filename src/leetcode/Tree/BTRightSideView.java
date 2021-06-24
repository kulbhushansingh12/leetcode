package leetcode.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import geeksforgeeks.tree.TreeNode;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return Collections.EMPTY_LIST;
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result.add(node.val);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return result;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, -1, result);
        return result;
    }


    public void rightSideViewHelper(TreeNode root, int level, List<Integer> rightSideElement) {
        if (root == null)
            return;

        if (level < rightSideElement.size()) {
            rightSideElement.add(root.val);
        }

        rightSideViewHelper(root.right, level+1, rightSideElement);
        rightSideViewHelper(root.left, level+1, rightSideElement);
    }
}
