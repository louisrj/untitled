package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Example:
 *
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII {

  public static void main(String[] args) {
    FourSumII fourSum = new FourSumII();
    System.out.println(fourSum.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
  }

  private int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
    Map<Integer, Integer> map = new HashMap<>();

    int sum;
    for (int i : a) {
      for (int j : b) {
        sum = i + j;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }

    int res = 0;
    for (int i : c) {
      for (int j : d) {
        res += map.getOrDefault(-1 * (i + j), 0);
      }
    }
    return res;
  }
}
