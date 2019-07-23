package linkedlists;


/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 */
public class MergeTwoLinkedLists {

  public static void main(String[] args) {

    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);


//    ListNode listNode = mergeTwoLists(l1, l2);
//
//    while (listNode != null) {
//      System.out.println(listNode.val);
//      listNode = listNode.next;
//    }

    System.out.println("-----------------------------");

    ListNode listNode1 = mergeTwoLists1(l1, l2);


    while (listNode1 != null) {
      System.out.println(listNode1.val);
      listNode1 = listNode1.next;
    }

    //
//    System.out.println("L1");
//    while (l1 != null) {
//      System.out.println(l1.val);
//      l1 = l1.next;
//    }
//
//
//    System.out.println("L1");
//    while (l2 != null) {
//      System.out.println(l2.val);
//      l2 = l2.next;
//    }
//

  }

  private static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;

    ListNode dummy = new ListNode(0);
    ListNode l3 = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        l3.next = l1;
        l1 = l1.next;
      } else {
        l3.next = l2;
        l2 = l2.next;
      }

      l3 = l3.next;

    }

    if (l1 != null) {
      l3.next = l1;
    }

    if (l2 != null) {
      l3.next = l2;
    }

    return dummy.next;
  }

  private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

}
