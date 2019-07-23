package array;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the
 * sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7 Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {

  public static void main(String[] args) {
    MinimumPathSum minimumPathSum = new MinimumPathSum();
    int[][] a = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };
    System.out.println(minimumPathSum.minPathSum(a));
  }

  private int minPathSum(int[][] grid) {
    return calculate(grid, 0, 0);
  }

  private int calculate(int[][] grid, int i, int j) {
    if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
    if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
    return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
  }

}
