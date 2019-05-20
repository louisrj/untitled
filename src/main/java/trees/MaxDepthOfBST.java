package trees;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaxDepthOfBST {

  public static void main(String[] args) {
    MaxDepthOfBST maxDepthOfBST = new MaxDepthOfBST();
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);

    System.out.println(maxDepthOfBST.maxDepth(treeNode));
  }

  private int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int left = 1 + maxDepth(root.left);
    int right = 1 + maxDepth(root.right);

    int max = Math.max(left, right);
    return max;

  }
}
