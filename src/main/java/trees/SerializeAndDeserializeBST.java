package trees;

import java.util.ArrayDeque;

/**
 * Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The input tree is guaranteed to be a binary search tree.
 *
 */
public class SerializeAndDeserializeBST {
  public static void main(String[] args) {
    SerializeAndDeserializeBST s = new SerializeAndDeserializeBST();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);
    String serialize = s.serialize(root);
    s.deserialize(serialize);
    System.out.println();
  }

  public StringBuilder postOrder(TreeNode root, StringBuilder sb) {
    if (root == null)
      return sb;
    postOrder(root.left, sb);
    postOrder(root.right, sb);
    sb.append(root.val);
    sb.append(' ');
    return sb;
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = postOrder(root, new StringBuilder());
    if (sb.length() > 0)
      sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb.toString());
    return sb.toString();
  }

  public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
    if (nums.isEmpty())
      return null;
    int val = nums.getLast();
    if (val < lower || val > upper)
      return null;

    nums.removeLast();
    TreeNode root = new TreeNode(val);
    root.right = helper(val, upper, nums);
    root.left = helper(lower, val, nums);
    return root;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isEmpty())
      return null;
    ArrayDeque<Integer> nums = new ArrayDeque<>();
    for (String s : data.split("\\s+"))
      nums.add(Integer.valueOf(s));
    return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
  }
}
