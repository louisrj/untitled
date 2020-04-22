package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So
 * the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFromDataStream {
  private PriorityQueue<Integer> minH;
  private PriorityQueue<Integer> maxH;

  /** initialize your data structure here. */
  public MedianFromDataStream() {
    minH = new PriorityQueue<>();
    /* By default Java provides min heap. For max heap, we need to pass in a appropriate comparator */
    maxH = new PriorityQueue<>( (ob1, ob2) -> ob2.compareTo(ob1));
  }

  public static void main(String[] args) {
    MedianFromDataStream m = new MedianFromDataStream();
    m.addNum(1);
    m.addNum(2);
    System.out.println(m.findMedian());
    m.addNum(3);
    System.out.println(m.findMedian());
  }

  private void addNum(int num) {
    maxH.add(num);
    minH.add(maxH.poll());
    if (minH.size() > maxH.size()) {
      maxH.add(minH.poll());
    }
  }

  private double findMedian() {
    if (minH.size() == maxH.size())
      return (double) (maxH.peek() + minH.peek()) * 0.5;
    else
      return (double) maxH.peek();
  }

}
