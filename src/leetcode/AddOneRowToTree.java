package leetcode;

//https://leetcode.com/problems/add-one-row-to-tree/
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        TreeNode temp = root;
        addOneRowHelper(temp, v, d);
        return root;
    }

    public void addOneRowHelper(TreeNode prev, int v, int d) {
        if (d-1 == 1) {
            TreeNode leftNode = new TreeNode(v);
            TreeNode rightNode = new TreeNode(v);
            TreeNode origLeft = prev.left;
            TreeNode origRight = prev.right;
            leftNode.left = origLeft;
            rightNode.right = origRight;
            prev.left = leftNode;
            prev.right = rightNode;
        } else {
            addOneRowHelper(prev.left, v, d - 1);
            addOneRowHelper(prev.right, v, d - 1);
        }
    }

    public static void main(String[] args) {
        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(6);
        TreeNode ll1 = new TreeNode(3);
        TreeNode lr1 = new TreeNode(1);
        TreeNode rl1 = new TreeNode(5);
        left.left = ll1;
        left.right = lr1;
        right.left = rl1;
        root.left = left;
        root.right = right;

        addOneRowToTree.addOneRow(root, 1, 2);
    }
}
