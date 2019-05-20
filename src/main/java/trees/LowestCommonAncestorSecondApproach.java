package trees;

public class LowestCommonAncestorSecondApproach {

  private TreeNode ans;

  public LowestCommonAncestorSecondApproach() {
    // Variable to store LCA node.
    this.ans = null;
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);

    LowestCommonAncestorSecondApproach lowestCommonAncestorSecondApproach = new LowestCommonAncestorSecondApproach();
    TreeNode treeNode = lowestCommonAncestorSecondApproach.lowestCommonAncestor(root, root.left.left, root.left.right.right);
    System.out.println(treeNode.val);

  }


  private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // Traverse the tree
    this.recurseTree(root, p, q);
    return this.ans;
  }

  private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

    // If reached the end of a branch, return false.
    if (currentNode == null) {
      return false;
    }

    // Left Recursion. If left recursion returns true, set left = 1 else 0
    int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

    // Right Recursion
    int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

    // If the current node is one of p or q
    int mid = (currentNode == p || currentNode == q) ? 1 : 0;


    // If any two of the flags left, right or mid become True
    if (mid + left + right >= 2) {
      this.ans = currentNode;
    }

    // Return true if any one of the three bool values is True.
    return (mid + left + right > 0);
  }

}
