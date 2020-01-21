package graphs;

import java.util.*;

public class RottingOranges {
  public static void main(String[] args) {
    List<Integer> row1 = Arrays.asList(0, 1, 1, 0, 1);
    List<Integer> row2 = Arrays.asList(0, 1, 0, 1, 0);
    List<Integer> row3 = Arrays.asList(0, 0, 0, 0, 1);
    List<Integer> row4 = Arrays.asList(0, 1, 0, 0, 0);
    List<List<Integer>> grid = new ArrayList<>();
    grid.add(row1);
    grid.add(row2);
    grid.add(row3);
    grid.add(row4);
    System.out.println(orangesRotting(4, 5, grid));
  }

  private static int orangesRotting(int rows, int columns, List<List<Integer>> grids) {
    int[] rowArray = new int[]{-1, 0, 1, 0};
    int[] colArray = new int[]{0, -1, 0, 1};

    // queue : all starting cells with rotten oranges
    Queue<Integer> queue = new ArrayDeque<>();
    Map<Integer, Integer> depth = new HashMap<>();
    int[][] grid = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        grid[i][j] = grids.get(i).get(j);
      }
    }

    for (int r = 0; r < rows; ++r)
      for (int c = 0; c < columns; ++c)
        if (grid[r][c] == 1) {
          int code = r * columns + c;
          queue.add(code);
          depth.put(code, 0);
        }

    int ans = 0;
    while (!queue.isEmpty()) {
      int code = queue.remove();
      int r = code / columns, c = code % columns;
      for (int k = 0; k < 4; ++k) {
        int nr = r + rowArray[k];
        int nc = c + colArray[k];
        if (0 <= nr && nr < rows && 0 <= nc && nc < columns && grid[nr][nc] == 0) {
          grid[nr][nc] = 1;
          int ncode = nr * columns + nc;
          queue.add(ncode);
          depth.put(ncode, depth.get(code) + 1);
          ans = depth.get(ncode);
        }
      }
    }
    return ans;
  }
}