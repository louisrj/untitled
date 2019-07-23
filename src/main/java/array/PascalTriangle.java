package array;

import java.util.ArrayList;
import java.util.List;

/**
 * LC118
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalTriangle {

  public static void main(String[] args) {
    List<List<Integer>> lists = majorityElement(4);

    lists.forEach(list -> {
      list.forEach(System.out::print);
      System.out.println();
    });
  }

  private static List<List<Integer>> majorityElement(int numRows) {
    List<List<Integer>> lists = new ArrayList<>();

    if (numRows == 0) {
      return lists;
    }

    List<Integer> first = new ArrayList<>();
    first.add(1);
    lists.add(first);

    for (int i = 1; i < numRows; i++) {
      List<Integer> cur = new ArrayList<>();
      List<Integer> prev = lists.get(i - 1);

      cur.add(1);

      for (int j = 1; j < i; j++) {
        cur.add(prev.get(j - 1) + prev.get(j));
      }

      cur.add(1);

      lists.add(cur);
    }

    return lists;

  }

}
