package trees;

import java.util.Stack;

/**
 * On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 * 
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 * 
 * What is the largest possible number of moves we can make?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Example 2:
 * 
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Example 3:
 * 
 * Input: stones = [[0,0]]
 * Output: 0
 * 
 * 
 * Note:
 * 
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 */
public class RemoveStones {

  public static void main(String[] args) {

    int[][] stones = {
        {0, 0},
        {0, 1},
        {1, 0},
        {1, 2},
        {2, 1},
        {2, 2}
    };

    RemoveStones removeStones = new RemoveStones();
    System.out.println(removeStones.removeStones(stones));
  }

  private int removeStones(int[][] stones) {
    int n = stones.length;

    // graph[i][0] = the length of the 'list' graph[i][1:]
    int[][] graph = new int[n][n];
    for (int i = 0; i < n; ++i)
      for (int j = i + 1; j < n; ++j)
        if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
          graph[i][++graph[i][0]] = j;
          graph[j][++graph[j][0]] = i;
        }

    int ans = 0;
    boolean[] seen = new boolean[n];
    for (int i = 0; i < n; ++i)
      if (!seen[i]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        seen[i] = true;
        ans--;
        while (!stack.isEmpty()) {
          int node = stack.pop();
          ans++;
          for (int k = 1; k <= graph[node][0]; ++k) {
            int nei = graph[node][k];
            if (!seen[nei]) {
              stack.push(nei);
              seen[nei] = true;
            }
          }
        }
      }

    return ans;
  }
}
