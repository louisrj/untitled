package trees;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3] 1 \ 2 / 3
 *
 * Output: [1,3,2]
 */
public class BinaryTreeInOrderTraversal {

  public static void main(String[] args) {
    BinaryTreeInOrderTraversal b = new BinaryTreeInOrderTraversal();

    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    b.inorderTraversal(root).forEach(System.out::println);

  }

  private List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    inOrderTraversalHelper(res, root);
    return res;
  }

  private void inOrderTraversalHelper(List<Integer> res, TreeNode root) {
    if (root != null) {
      inOrderTraversalHelper(res, root.left);
      res.add(root.val);
      inOrderTraversalHelper(res, root.right);
    }
  }

}
