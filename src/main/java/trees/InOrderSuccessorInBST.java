package trees;

public class InOrderSuccessorInBST {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);

    InOrderSuccessorInBST inOrderSuccessorInBST = new InOrderSuccessorInBST();
    TreeNode successor = inOrderSuccessorInBST.successor(root, root.left);
    System.out.println(successor.val);
  }

  private TreeNode successor(TreeNode root, TreeNode p) {
    if (root == null)
      return null;

    if (root.val <= p.val) {
      return successor(root.right, p);
    } else {
      TreeNode left = successor(root.left, p);
      return (left != null) ? left : root;
    }
  }
}
