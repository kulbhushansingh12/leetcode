package geeksforgeeks.tree;

//https://leetcode.com/problems/path-sum/
public class PathSum {
   public boolean hasPathSum(TreeNode root, int sum) {

      return helper(root, 0, sum);
   }

   public boolean helper(TreeNode root, int currentSum, int sum) {
      if (root == null) return currentSum == sum;

      //If leaf node
      if (root.right == null && root.left == null)
         return (currentSum + root.val) == sum;

      boolean left  = (root.left != null) ? helper(root.left, root.val + currentSum, sum) : false;
      boolean right = (root.right != null) ? helper(root.right, root.val+currentSum, sum) : false;
      return left || right;
   }

   public static void main(String[] args) {
      TreeNode node1 = new TreeNode(7);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(11, node1, node2);
      TreeNode node4 = new TreeNode(4, node3, null);

      TreeNode node5 = new TreeNode(1);
      TreeNode node6 = new TreeNode(4, null, node5);
      TreeNode node7 = new TreeNode(13);
      TreeNode node8 = new TreeNode(8, node7, node6);

      TreeNode root = new TreeNode(5, node4, node8);

      PathSum pathSum = new PathSum();
      System.out.println(pathSum.hasPathSum(root, 22));
   }
}
