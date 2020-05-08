package leetcode;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class BSTFromPreorder {
   public TreeNode bstFromPreorder(int[] preorder) {
      TreeNode root = null;

      for(int val : preorder)
         root = helper(root, val);

      return root;
   }

   private TreeNode helper(TreeNode node, int val) {
      if(node == null) return new TreeNode(val);

      if(val < node.val)
         node.left = helper(node.left, val);
      else
         node.right = helper(node.right, val);

      return node;
   }


   public static void main(String[] args) {
      BSTFromPreorder preorder = new BSTFromPreorder();
      preorder.bstFromPreorder(new int[]{8,5,1,7,10,12});
   }
}
