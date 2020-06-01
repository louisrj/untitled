package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {
  public static void main(String[] args) {
    PathSumIII pathSumIII = new PathSumIII();
    TreeNode treeNode = new TreeNode(10);
    treeNode.left = new TreeNode(5);
    treeNode.right = new TreeNode(-3);
    treeNode.left.left = new TreeNode(3);
    treeNode.left.right = new TreeNode(2);
    treeNode.right.right = new TreeNode(11);
    treeNode.left.left.left = new TreeNode(3);
    treeNode.left.left.right = new TreeNode(-2);
    treeNode.left.right.right = new TreeNode(1);

    System.out.println(pathSumIII.pathSum(treeNode, 8));
  }

  public int pathSum(TreeNode root, int sum) {
    Map<Integer, Integer> preSum = new HashMap<>();
    preSum.put(0,1);
    return helper(root, 0, sum, preSum);
  }

  public int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> preSum) {
    if (root == null) {
      return 0;
    }

    currSum += root.val;
    int res = preSum.getOrDefault(currSum - target, 0);
    preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

    res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
    preSum.put(currSum, preSum.get(currSum) - 1);
    return res;
  }
}
