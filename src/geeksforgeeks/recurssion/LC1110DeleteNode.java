    package geeksforgeeks.recurssion;

    import java.util.ArrayList;
    import java.util.List;

    import geeksforgeeks.tree.TreeNode;

    // https://leetcode.com/problems/delete-nodes-and-return-forest/
    public class LC1110DeleteNode {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            List<TreeNode> forest = new ArrayList<>();
            TreeNode isDeletedNode = delNodesHelper(root, to_delete, null, forest, false);
            if (isDeletedNode !=  null) {
                forest.add(isDeletedNode);
            }
            return forest;
        }

        private TreeNode delNodesHelper(TreeNode root, int[] to_delete, TreeNode prevNode, List<TreeNode> forest, boolean isLeft) {
            if (root.left != null) {
                delNodesHelper(root.left, to_delete, root, forest, true);
            }
            if (root.right != null) {
                delNodesHelper(root.right, to_delete, root, forest, false);
            }

            // current node to be deleted
            boolean isCurrentNodeToBeDeleted = isPresent(root.val, to_delete);
            if (prevNode!=null && isCurrentNodeToBeDeleted) {
                if (isLeft) {
                    prevNode.left = null;
                } else {
                    prevNode.right = null;
                }
            }

            // if prev node to be deleted
            if (prevNode != null && isPresent(prevNode.val, to_delete)&&!isCurrentNodeToBeDeleted) {
                forest.add(root);
            }

            return isCurrentNodeToBeDeleted ? null : root;
        }

        private boolean isPresent(int num, int[] nums) {
            for (int no : nums) {
                if (num == no) {
                    return true;
                }
            }
            return false;
        }
    }
