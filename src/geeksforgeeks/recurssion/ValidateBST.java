package geeksforgeeks.recurssion;

import geeksforgeeks.tree.TreeNode;

// https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return validateBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateBSTHelper(TreeNode root, long min, long max) {
        if (root == null) return true;

        return root.val < max && root.val > min && validateBSTHelper(root.left, min, Math.min(max, root.val))
                && validateBSTHelper(root.right, Math.max(root.val, min), max);
    }

    public static void main(String[] args) {
        test1(); //false;
        test2(); //true
        test3(); //false
        test4(); // true
        test5();//false
    }

    private static void test2() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(root));
    }

    private static void test5() {
        TreeNode root = new TreeNode(1, new TreeNode(1), null);
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(root));
    }

    private static void test4() {
        TreeNode root = new TreeNode(2147483647);
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(root));
    }

    private static void test3() {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4));
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(root));
    }

    private static void test1() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        root.left = left;
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(7);
        right.left = left1;
        right.right = right1;

        root.right = right;
        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.isValidBST(root));
    }
}
