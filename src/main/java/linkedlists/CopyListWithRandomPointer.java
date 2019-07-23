package linkedlists;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the
 * list or null.
 *
 * Return a deep copy of the list.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 *
 *
 * Note:
 *
 * You must return the copy of the given head as a reference to the cloned list.
 */
public class CopyListWithRandomPointer {

  // HashMap which holds old nodes as keys and new nodes as its values.
  private HashMap<Node, Node> visitedHash = new HashMap<>();

  public static void main(String[] args) {
    CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
    Node third = new Node(-2, null, null);
    Node second = new Node(7, null, third);
    Node first = new Node(4, second, third);

    copyListWithRandomPointer.copyRandomList(first);

  }

  private Node copyRandomList(Node head) {

    if (head == null) {
      return null;
    }

    // If we have already processed the current node, then we simply return the cloned version of
    // it.
    if (this.visitedHash.containsKey(head)) {
      return this.visitedHash.get(head);
    }

    // Create a new node with the value same as old node. (i.e. copy the node)
    Node node = new Node(head.val, null, null);

    // Save this value in the hash map. This is needed since there might be
    // loops during traversal due to randomness of random pointers and this would help us avoid
    // them.
    this.visitedHash.put(head, node);

    // Recursively copy the remaining linked list starting once from the next pointer and then from
    // the random pointer.
    // Thus we have two independent recursive calls.
    // Finally we update the next and random pointers for the new node created.
    node.next = this.copyRandomList(head.next);
    node.random = this.copyRandomList(head.random);

    return node;
  }
}