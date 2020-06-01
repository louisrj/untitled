package linkedlists;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReverseNodesInKGroup {
  public static void main(String[] args) {
    ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);
//    ListNode listNode = reverseNodesInKGroup.reverseKGroup(l1, 2);
    ListNode listNode1 = reverseNodesInKGroup.reverseKGroupSecond(l1, 2);
    ListNode cur = listNode1;
    while (cur != null) {
      System.out.print(cur.val + "\t");
      cur = cur.next;
    }

  }

  private ListNode reverseKGroup(ListNode head, int k) {
    ListNode current = head;
    ListNode next = null;
    ListNode prev = null;

    int count = 0;
    ListNode counter = head;
    while (count < k) {
      if (counter == null) return head;
      counter = counter.next;
      count++;
    }

    /* Reverse first k nodes of linked list */
    while (count > 0 && current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count--;
    }

    /* next is now a pointer to (k+1)th node
    Recursively call for the list starting from current.
    And make rest of the list as next of first node */
    if (next != null)
      head.next = reverseKGroup(next, k);

    // prev is now head of input list
    return prev;
  }


  public ListNode reverseKGroupSecond(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while (curr != null && count != k) { // find the k+1 node
      curr = curr.next;
      count++;
    }

    if (count == k) { // if k+1 node is found
      curr = reverseKGroupSecond(curr, k); // reverse list with k+1 node as head
      // head - head-pointer to direct part,
      // curr - head-pointer to reversed part;
      while (count-- > 0) { // reverse current k-group:
        ListNode tmp = head.next; // tmp - next head in direct part
        head.next = curr; // preappending "direct" head to the reversed list
        curr = head; // move head of reversed part to a new node
        head = tmp; // move "direct" head to the next node in direct part
      }
      head = curr;
    }
    return head;
  }
}
