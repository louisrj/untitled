package queue;

import java.util.NoSuchElementException;

public class Queue {

  private Node first;
  private Node last;
  private int size;

  private static void print() {

  }

  public static void main(String[] args) {
    Queue q = new Queue();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    print();
    int poll = q.poll();
    System.out.println("Deleted item : " + poll);
    print();
  }

  private boolean isEmpty() {
    return first == null;
  }

  private int size() {
    return size;
  }

  private void add(int val) {
    Node oldlast = last;
    last = new Node(val);
    if (isEmpty()) first = last;
    else oldlast.next = last;
    size++;
  }

  private int poll() {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    int item = first.val;
    first = first.next;
    size--;
    if (isEmpty()) last = null;   // to avoid loitering
    return item;
  }

  private static class Node {
    int val;
    Node next;

    private Node(int val) {
      this.val = val;
      this.next = null;
    }
  }
}
