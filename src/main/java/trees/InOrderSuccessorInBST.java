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
    if (p.right != null) {
      return minValue(p.right);
    }

    TreeNode successor = null;
    while (root != null) {
      if (root.val > p.val) {
        successor = root;
        root = root.left;
      } else if (root.val < p.val) {
        root = root.right;
      } else break;
    }
    return successor;
  }

  private TreeNode minValue(TreeNode p) {
    while (p.left != null) {
      p = p.left;
    }

    return p;
  }
}
