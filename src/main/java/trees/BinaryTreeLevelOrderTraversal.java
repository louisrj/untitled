package trees;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {
  List<List<Integer>> levels = new ArrayList<List<Integer>>();

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    //Recursive solution
    BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
    binaryTreeLevelOrderTraversal.recursiveLevelOrder(root).forEach(System.out::print);

    //Iterative Solution
    binaryTreeLevelOrderTraversal.iterativeLevelOrder(root).forEach(System.out::print);


  }

  //-----------------------Recursive------------------------------------------------------------------------------------
  private List<List<Integer>> recursiveLevelOrder(TreeNode root) {
    if (root == null) return levels;
    recursiveHelper(root, 0);
    return levels;
  }

  private void recursiveHelper(TreeNode node, int level) {
    // start the current level
    if (levels.size() == level)
      levels.add(new ArrayList<Integer>());

    // fulfil the current level
    levels.get(level).add(node.val);

    // process child nodes for the next level
    if (node.left != null)
      recursiveHelper(node.left, level + 1);
    if (node.right != null)
      recursiveHelper(node.right, level + 1);
  }

  //-----------------------Iterative------------------------------------------------------------------------------------
  private List<List<Integer>> iterativeLevelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null) return levels;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while ( !queue.isEmpty() ) {
      // start the current level
      levels.add(new ArrayList<>());

      // number of elements in the current level
      int level_length = queue.size();
      for(int i = 0; i < level_length; ++i) {
        TreeNode node = queue.remove();

        // fulfill the current level
        levels.get(level).add(node.val);

        // add child nodes of the current level
        // in the queue for the next level
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      // go to next level
      level++;
    }
    return levels;

  }

}
