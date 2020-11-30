package linkedlists;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity. int get(int key) Return the value of the
 * key if the key exists, otherwise return -1. void put(int key, int value) Update the value of the key if the key
 * exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this
 * operation, evict the least recently used key. Follow up: Could you do get and put in O(1) time complexity?
 *
 * Example 1:
 *
 * Input ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"] [[2], [1, 1], [2, 2], [1], [3, 3],
 * [2], [4, 4], [1], [3], [4]] Output [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation LRUCache lRUCache = new LRUCache(2); lRUCache.put(1, 1); // cache is {1=1} lRUCache.put(2, 2); // cache
 * is {1=1, 2=2} lRUCache.get(1);    // return 1 lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found) lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found) lRUCache.get(3);    // return 3 lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000 0 <= key <= 3000 0 <= value <= 104 At most 3 * 104 calls will be made to get and put.
 */
public class LruCache {
    private final int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;

    public LruCache(int capacity) {
      this.capacity = capacity;
      this.head = new Node(0, 0);
      this.tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }

    public static void main(String[] args) {
      LruCache cache = new LruCache(2);
      cache.put(1, 1);
      cache.put(2, 2);
      cache.put(3, 3);
      System.out.println(cache.get(1));
      System.out.println(cache.get(2));
    }

    private void addToHead(Node node) {
      node.prev = head;
      node.next = head.next;
      head.next = node;
    }

    private void deleteNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    private int get(int key) {
      if (!map.containsKey(key)) return -1;

      Node node = map.get(key);
      deleteNode(node);
      deleteNode(node);

      return node.val;
    }

    private void put(int key, int value) {
      if (map.containsKey(key)) {
        Node node = map.get(key);
        deleteNode(node);
        addToHead(node);
        node.val = value;
      } else {
        if (map.size() >= capacity) {
          int val = tail.prev.val;
          deleteNode(tail.prev);
          map.remove(val);
        }

        Node node = new Node(key, value);
        addToHead(node);
        map.put(key, node);

      }
    }

    static class Node {
      private int key;
      private int val;
      private Node prev;
      private Node next;

      public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
      }
    }
}
