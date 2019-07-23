package linkedlists;

public class MyLinkedList {

  private Node head;

  private MyLinkedList() {

  }

  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.add(3);
    myLinkedList.add(1);
    myLinkedList.add(2);
    myLinkedList.add(4);
    myLinkedList.printList();
    myLinkedList.remove(2);
    System.out.println("After deleting 2");
    myLinkedList.printList();

    System.out.println("After deleting 4");
    myLinkedList.remove(4);
    myLinkedList.printList();

    MyLinkedList myLinkedList1 = new MyLinkedList();
    myLinkedList1.add(2);
    myLinkedList1.printList();
  }

  private void printList() {
    System.out.println("Printing");
    Node cur = head;

    while (cur != null) {
      System.out.println(cur.val);
      cur = cur.next;
    }
  }

  private void add(int val) {
    Node node = new Node(val, null);
    if (head == null || head.val >= node.val) {
      node.next = head;
      head = node;
    } else {
      Node cur = head;

      while (cur.next != null && cur.next.val < node.val) {
        cur = cur.next;
      }

      node.next = cur.next;
      cur.next = node;
    }
  }

  private void remove(int val) {
    if (head == null) return;

    if (head.val == val) {
      head = head.next;
      return;
    }

    Node cur = head;
    Node prev = null;

    while (cur != null && cur.val != val) {
      prev = cur;
      cur = cur.next;
    }

    if (cur != null) {
      prev.next = cur.next;
    }
  }

  private static class Node {
    int val;
    Node next;

    Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }
}