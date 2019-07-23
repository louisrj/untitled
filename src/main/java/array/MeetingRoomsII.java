package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the
 * minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRoomsII {

  public static void main(String[] args) {
    int[][] intervals = {
        {0, 30},
        {5, 10},
        {15, 20}
    };

    MeetingRoomsII meetingRoomsII = new MeetingRoomsII();

    System.out.println(meetingRoomsII.minMeetingRooms(intervals));
  }

  private int minMeetingRooms(int[][] intervals) {

    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

    PriorityQueue<Integer> q = new PriorityQueue(intervals.length,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o1 - o2;
          }
        });

    q.add(intervals[0][1]);

    for (int i = 1; i < intervals.length; i++) {
      if (q.peek() <= intervals[i][0]) {
        q.poll();
      }
      q.add(intervals[i][1]);
    }

    return q.size();
  }

}
