import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

  public static void main(String[] args) {
    Tester tester = new Tester();

//    [1,3],[2,6],[8,10],[15,18]
    int[][] intervals = {
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    };

    Arrays.stream(tester.merge(intervals)).forEach(a -> {
      Arrays.stream(a).forEach(a1 -> {
        System.out.println(a1 + "\t");
      });
    });
  }

  private int[][] merge(int[][] intervals) {

    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

    int[] prev = null;
    List<int[]> res = new ArrayList<>();

    for (int[] cur : intervals) {
      if (prev == null || cur[0] > prev[1]) {
        prev = cur;
        res.add(cur);
      } else if (cur[1] > prev[1]) {
        prev[1] = cur[1];
      }
    }
    int[][] result = new int[res.size()][2];
    return res.toArray(result);
  }

}
