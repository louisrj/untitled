package trees;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 * 0 / \ -3   9 /   / -10  5
 */
public class SortedArrayToBinarySearchTree {

  public static void main(String[] args) {

    SortedArrayToBinarySearchTree s = new SortedArrayToBinarySearchTree();
    TreeNode tree = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    printTree(tree);
  }

  private static void printTree(TreeNode root) {
    if (root != null) {
      printTree(root.left);
      System.out.println(root.val);
      printTree(root.right);
    }
  }

  private TreeNode sortedArrayToBST(int[] num) {
    if (num.length == 0) {
      return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
  }

  private TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
      return null;
    }

    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
  }

}
