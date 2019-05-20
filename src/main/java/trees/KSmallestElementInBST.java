package trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary search tree, write a function kthSmallestIterative to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallestIterative routine?
 */
public class KSmallestElementInBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);

    KSmallestElementInBST kSmallestElementInBST = new KSmallestElementInBST();
    System.out.println(kSmallestElementInBST.kthSmallestRecursive(root, 3));
    System.out.println(kSmallestElementInBST.kthSmallestIterative(root, 3));
  }

  //--------------Recursive--------------------------------
  private int kthSmallestRecursive(TreeNode root, int k) {
    ArrayList<Integer> nums = inorder(root, new ArrayList<>());
    return nums.get(k - 1);
  }

  private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) return arr;
    inorder(root.left, arr);
    arr.add(root.val);
    inorder(root.right, arr);
    return arr;
  }

  //---------------Iterative------------------------------
  private int kthSmallestIterative(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();

    while (true) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }
}
