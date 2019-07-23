package array;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 */
public class TopKFrequentElements {

  public static void main(String[] args) {
    TopKFrequentElements t = new TopKFrequentElements();
    List<Integer> result = t.topKFrequent(new int[]{11, 11, 11, 12, 12, 13}, 2);

    System.out.println(result);
  }

  private List<Integer> topKFrequent(int[] nums, int k) {
    // build hash map : character and how often it appears
    Map<Integer, Integer> count = new HashMap<>();
    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    PriorityQueue<Integer> heap =
        new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

    // keep k top frequent elements in the heap
    for (int n : count.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }

    // build output list
    List<Integer> top_k = new LinkedList<>();
    while (!heap.isEmpty())
      top_k.add(heap.poll());
    Collections.reverse(top_k);
    return top_k;
  }

}
