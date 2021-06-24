package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class LC103ZigZagLOT {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        Stack<TreeNode> ltr = new Stack<>();
        Stack<TreeNode> rtl = new Stack<>();

        rtl.push(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!rtl.isEmpty() || !ltr.isEmpty()) {
            boolean isRtl = !rtl.isEmpty();
            int size = isRtl? rtl.size() : ltr.size();
            List<Integer> currList = new ArrayList<>();
            if (isRtl) {
                for (int i=0; i<size; i++) {
                    TreeNode curr = rtl.pop();
                    currList.add(curr.val);
                    if (curr.left != null) {
                        ltr.push(curr.left);
                    }
                    if (curr.right != null) {
                        ltr.push(curr.right);
                    }
                }
            } else {
                for (int i=0; i<size; i++) {
                    TreeNode curr = ltr.pop();
                    currList.add(curr.val);
                    if (curr.right != null) {
                        rtl.push(curr.right);
                    }
                    if (curr.left != null) {
                        rtl.push(curr.left);
                    }
                }
            }
            res.add(currList);
        }

        return res;
    }

    public static void main(String[] args) {
        LC103ZigZagLOT zigZagLOT = new LC103ZigZagLOT();
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode left = new TreeNode(9);
        TreeNode root = new TreeNode(3, left, right);
        zigZagLOT.zigzagLevelOrder(root);

    }
}
