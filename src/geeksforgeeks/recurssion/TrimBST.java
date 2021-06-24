package geeksforgeeks.recurssion;

import java.util.HashMap;
import java.util.Map;

import geeksforgeeks.tree.TreeNode;

// https://leetcode.com/problems/trim-a-binary-search-tree/
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;

        if (root.val < low) return trimBST(root.left, low, high);
        if (root.val > high) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry mapKey : map.entrySet()) {

        }
        return root;
    }


}
