package geeksforgeeks.tree;

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class TreeFromInorderAndPostOrder {
   public TreeNode buildTree(int[] inorder, int[] postorder) {
      return build(postorder.length - 1, 0, inorder.length-1, inorder, postorder);
   }
   private TreeNode build (int postOrderRoot, int left, int right, int[] inorder, int[] postorder)  {
      if (left > right || postOrderRoot < 0)
         return null;

      TreeNode node = new TreeNode(postorder[postOrderRoot]);
      int i = 0;
      for (; i<inorder.length; i++) {
         if (node.val == inorder[i])
            break;
      }

      node.right = build(--postOrderRoot, i+1, right, inorder, postorder);
      // to ignore the right child from the root
      node.left = build(postOrderRoot - (right -i), left, i-1, inorder, postorder);
      return node;
   }

   public static void main(String[] args) {
      TreeFromInorderAndPostOrder tree = new TreeFromInorderAndPostOrder();
      TreeNode node = tree.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
      System.out.println(node);
   }
}
