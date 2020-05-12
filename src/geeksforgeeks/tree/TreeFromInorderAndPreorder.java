package geeksforgeeks.tree;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class TreeFromInorderAndPreorder {
   public TreeNode buildTree(int[] preorder, int[] inorder) {
      return builder(0, 0, inorder.length - 1, preorder, inorder);
   }

   private TreeNode builder(int rootIndex, int left, int right, int[] preOrder, int[] inOrder) {
      if (left > right || rootIndex >= preOrder.length)
         return null;

      TreeNode node = new TreeNode(preOrder[rootIndex]);

      int inIndex = 0;

      for (int i=left; i <= right; i++) {
         if (inOrder[i] == node.val) {
            inIndex = i;
            break;
         }
      }

      node.left = builder(rootIndex + 1, left, inIndex - 1, preOrder, inOrder);

      node.right = builder(rootIndex + (inIndex - left) + 1, inIndex + 1, right, preOrder, inOrder);

      return node;
   }

   public static void main(String[] args) {
      TreeFromInorderAndPreorder tree = new TreeFromInorderAndPreorder();
      TreeNode node = tree.buildTree(new int[] {3,9,20,15,7}, new int[]{9,3,15,20,7});
      System.out.println(node);
   }
}
