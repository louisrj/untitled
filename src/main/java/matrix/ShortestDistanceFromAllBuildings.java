package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
  public static void main(String[] args) {
    ShortestDistanceFromAllBuildings s = new ShortestDistanceFromAllBuildings();
    int[][] grid = new int[][]{
        {1, 0, 2, 0, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0}
    };
    System.out.println(s.shortestDistance(grid));
  }

  private int shortestDistance(int[][] grid) {
    if (grid == null || grid[0].length == 0) return 0;
    final int[] shift = new int[]{0, 1, 0, -1, 0};

    int row = grid.length, col = grid[0].length;
    int[][] distance = new int[row][col];
    int[][] reach = new int[row][col];
    int buildingNum = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          buildingNum++;
          Queue<int[]> myQueue = new LinkedList<>();
          myQueue.offer(new int[]{i, j});

          boolean[][] isVisited = new boolean[row][col];
          int level = 1;
          while (!myQueue.isEmpty()) {
            System.out.println("-----------Distance---------");
            for (int m = 0; m < grid.length; m++) {
              for (int n = 0; n < grid[0].length; n++) {
                System.out.print(distance[m][n] + "\t");
              }
              System.out.println();
            }
            System.out.println("-----------Reach---------");
            for (int m = 0; m < grid.length; m++) {
              for (int n = 0; n < grid[0].length; n++) {
                System.out.print(reach[m][n] + "\t");
              }
              System.out.println();
            }

            int qSize = myQueue.size();
            for (int q = 0; q < qSize; q++) {
              int[] curr = myQueue.poll();

              for (int k = 0; k < 4; k++) {
                int nextRow = curr[0] + shift[k];
                int nextCol = curr[1] + shift[k + 1];

                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
                    && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
                  //The shortest distance from [nextRow][nextCol] to thic building
                  // is 'level'.
                  distance[nextRow][nextCol] += level;
                  reach[nextRow][nextCol]++;

                  isVisited[nextRow][nextCol] = true;
                  myQueue.offer(new int[]{nextRow, nextCol});
                }
              }
            }
            level++;
          }
        }
      }
    }

    int shortest = Integer.MAX_VALUE;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
          shortest = Math.min(shortest, distance[i][j]);
        }
      }
    }
    return shortest == Integer.MAX_VALUE ? -1 : shortest;
  }
}
