package linkedlists;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 *
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
  public static void main(String[] args) {
    MergeKSortedLists m = new MergeKSortedLists();

    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);

    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);


    ListNode listNode = m.mergeKLists(new ListNode[]{l1, l2, l3});
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }

  private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode h = new ListNode(0);
    ListNode ans = h;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        h.next = l1;
        h = h.next;
        l1 = l1.next;
      } else {
        h.next = l2;
        h = h.next;
        l2 = l2.next;
      }
    }
    if (l1 == null) {
      h.next = l2;
    }
    if (l2 == null) {
      h.next = l1;
    }
    return ans.next;
  }

  private ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    int interval = 1;

    while (interval < lists.length) {
      System.out.println(lists.length);
      for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
        lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
      }
      interval *= 2;
    }

    return lists[0];
  }
}
