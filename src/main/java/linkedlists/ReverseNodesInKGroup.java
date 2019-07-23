package linkedlists;

public class ReverseNodesInKGroup {
  public static void main(String[] args) {
    ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);
    ListNode listNode = reverseNodesInKGroup.reverseKGroup(l1, 2);
    ListNode cur = listNode;
    while (cur != null) {
      System.out.print(cur.val + "\t");
      cur = cur.next;
    }

  }

  private ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while (curr != null && count != k) { // find the k+1 node
      curr = curr.next;
      count++;
    }
    if (count == k) { // if k+1 node is found
      curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
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
