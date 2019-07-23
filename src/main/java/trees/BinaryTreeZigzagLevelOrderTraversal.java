package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    BinaryTreeZigzagLevelOrderTraversal zigZag = new BinaryTreeZigzagLevelOrderTraversal();

    List<List<Integer>> lists = zigZag.zigzagLevelOrder(root);

    lists.forEach(System.out::print);

  }

  private List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> sol = new ArrayList<>();
    travel(root, sol, 0);
    return sol;
  }

  private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
    if (curr == null) return;

    if (sol.size() <= level) {
      List<Integer> newLevel = new LinkedList<>();
      sol.add(newLevel);
    }

    List<Integer> collection = sol.get(level);
    if (level % 2 == 0)
      collection.add(curr.val);
    else
      collection.add(0, curr.val);

    travel(curr.left, sol, level + 1);
    travel(curr.right, sol, level + 1);
  }

}
