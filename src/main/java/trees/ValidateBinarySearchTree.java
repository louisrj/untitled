package trees;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *
 * Input:
 *
 * / \
 * 1   3
 * Output: true
 * Example 2:
 *
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

  public static void main(String[] args) {

    ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.right = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.right.left = new TreeNode(4);

    System.out.println(validateBinarySearchTree.isValidBST(root));

  }

  private boolean isBSTHelper(TreeNode node, Integer lower_limit, Integer upper_limit) {
    if ((lower_limit != null) && (node.val <= lower_limit))
      return false;
    if ((upper_limit != null) && (upper_limit <= node.val))
      return false;

    boolean left = node.left == null || isBSTHelper(node.left, lower_limit, node.val);
    if (left) {
      boolean right = node.right == null || isBSTHelper(node.right, node.val, upper_limit);
      return right;
    } else
      return false;
  }

  private boolean isValidBST(TreeNode root) {
    if (root == null)
      return true;

    return isBSTHelper(root, null, null);
  }
}
