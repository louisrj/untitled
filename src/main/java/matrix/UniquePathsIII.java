package matrix;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 *
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.f
 */
public class UniquePathsIII {
  public static void main(String[] args) {
    UniquePathsIII u = new UniquePathsIII();
    int[][] g = new int[][]{
        {1, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 2, -1}
    };
    System.out.println(u.uniquePathsIII(g));
  }

  private int uniquePathsIII(int[][] g) {
    int x = 0, y = 0, empty = 0;
    for (int i = 0; i < g.length; i++)
      for (int j = 0; j < g[0].length; j++)
        if (g[i][j] == 0)
          ++empty;
        else if (g[i][j] == 1) {
          x = i;
          y = j;
        }

    return dfs(g, x, y, -1, empty);
  }

  private int dfs(int[][] g, int i, int j, int count, int need) {
    if (i < 0 || i == g.length || j < 0 || j == g[0].length || g[i][j] == -1) return 0;
    if (g[i][j] == 2) {
      if (count == need)
        return 1;
      else
        return 0;
    }
    g[i][j] = -1;
    int total = dfs(g, i - 1, j, count + 1, need);
    total += dfs(g, i, j + 1, count + 1, need);
    total += dfs(g, i + 1, j, count + 1, need);
    total += dfs(g, i, j - 1, count + 1, need);
    g[i][j] = 0;
    return total;
  }

}
