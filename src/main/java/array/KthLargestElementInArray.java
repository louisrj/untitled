package array;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not
 * the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInArray {
  public static void main(String[] args) {
    KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
    System.out.println(kthLargestElementInArray.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
  }

  private int findKthLargest(int[] nums, int k) {
    // init heap 'the smallest element first'
    PriorityQueue<Integer> heap =
        new PriorityQueue<>((n1, n2) -> n1 - n2);

    // keep k largest elements in the heap
    for (int n: nums) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }

    // output
    return heap.poll();
  }


}
