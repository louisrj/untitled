package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 *You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example:
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class WallsAndGates {
  public static void main(String[] args) {
    WallsAndGates w = new WallsAndGates();
    int[][] rooms = new int[][]{
        {2147483647, -1, 0, 2147483647},
        {2147483647, 2147483647, 2147483647, -1},
        {2147483647, -1, 2147483647, -1},
        {0, -1, 2147483647, 2147483647}
    };

    w.wallsAndGates(rooms);

    for (int[] a : rooms) {
      for (int value : a) {
        System.out.print(value);
        System.out.print(" ");

      }
      System.out.println();
    }
  }

  private void wallsAndGates(int[][] rooms) {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{-1, 0, 1, 0};

    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 0) {
          q.offer(new int[]{i, j});
        }
      }
    }

    while (!q.isEmpty()) {
      int[] a = q.poll();
      int r = a[0], c = a[1];
      for (int k = 0; k < 4; k++) {
        int nr = r + dx[k], nc = c + dy[k];
        if (nr < 0 || nr >= rooms.length || nc < 0 || nc >= rooms[0].length || rooms[nr][nc] != 2147483647) continue;

        rooms[nr][nc] = rooms[r][c] + 1;
        q.offer(new int[]{nr, nc});
      }
    }
  }

}
