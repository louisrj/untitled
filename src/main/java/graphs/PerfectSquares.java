package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum
 * to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 */
public class PerfectSquares {
  public static void main(String[] args) {
    PerfectSquares perfectSquares = new PerfectSquares();
    System.out.println(perfectSquares.numSquares(13));

  }

  private int numSquares(int n) {
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    q.offer(0);
    visited.add(0);
    int depth = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      depth++;
      while (size-- > 0) {
        int u = q.poll();
        for (int i = 1; i * i <= n; i++) {
          int v = u + i * i;
          if (v == n) {
            return depth;
          }
          if (v > n) {
            break;
          }
          if (!visited.contains(v)) {
            q.offer(v);
            visited.add(v);
          }
        }
      }
    }
    return depth;
  }
}
