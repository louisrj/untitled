package stack;

import java.util.NoSuchElementException;

public class MyStack {
  private Node first;
  private int size;

  private MyStack() {
    first = null;
    size = 0;
  }

  private static class Node {
    int val;
    Node next;

    Node(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return size;
  }

  private void push(int val) {
      Node node = new Node(val);
      Node oldFirst = first;
      first = node;
      first.next = oldFirst;
      size++;
  }

  private int pop() {
    if(isEmpty()) throw new NoSuchElementException("Empty stack");

    int val = first.val;
    first = first.next;
    size--;
    return val;
  }

  public void print() {
    Node temp = first;
    while (temp != null) {
      System.out.print(temp.val + "\t");
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.print();
    int pop = stack.pop();
    System.out.println("Deleted item : " + pop);
    stack.print();
  }

}
