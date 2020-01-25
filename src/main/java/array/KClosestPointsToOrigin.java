package array;

import java.util.*;

public class KClosestPointsToOrigin {
  public static void main(String[] args) {
    KClosestPointsToOrigin k = new KClosestPointsToOrigin();
    int[][] a = new int[][]{
        {1, 3},
        {-2, 2}
    };
    int[][] ints = k.kClosest(a, 1);
    for (int[] anInt : ints) {
      for (int j = 0; j < ints[0].length; j++) {
        System.out.print(anInt[j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  private int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
    for (int[] p : points) {
      pq.offer(p);
      if (pq.size() > K) {
        pq.poll();
      }
    }
    int[][] res = new int[K][2];
    while (K > 0) {
      res[--K] = pq.poll();
    }
    return res;
  }
}
