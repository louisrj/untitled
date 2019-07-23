package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

  public static void main(String[] args) {
    int[][] intervals = {
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    };

    MergeIntervals mergeIntervals = new MergeIntervals();
    int[][] merge = mergeIntervals.merge(intervals);

    System.out.println(merge[0]);
    System.out.println();
    for (int[] ints : merge) {
      for (int j = 0; j < merge[0].length; j++) {
        System.out.print(ints[j]);
        System.out.print("\t");
      }
      System.out.println();
    }
  }

  private int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> ret = new ArrayList<>();

    int[] prev = null;
    //Input: [[1,3],[2,6],[8,10],[15,18]]

    for (int[] inter : intervals) {
      //if prev is null or curr.start > prev.end, add the interval
      if (prev == null || inter[0] > prev[1]) {
        ret.add(inter);
        prev = inter;
      } else if (inter[1] > prev[1]) {
        // curr.end > prev.end, modify the element already in list
        prev[1] = inter[1];
      }
    }
    return ret.toArray(new int[ret.size()][2]);
  }
}
