package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 */
public class CriticalConnectionsInNetwork {
  private int time = 0; // time when discover each vertex

  public static void main(String[] args) {
    CriticalConnectionsInNetwork c = new CriticalConnectionsInNetwork();
    System.out.println(c.criticalConnections(4, Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3))));
  }

  private List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    int[] disc = new int[n], low = new int[n];
    // use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
    List<Integer>[] graph = new ArrayList[n];
    List<List<Integer>> res = new ArrayList<>();
    Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    // build graph
    for (int i = 0; i < connections.size(); i++) {
      int from = connections.get(i).get(0), to = connections.get(i).get(1);
      graph[from].add(to);
      graph[to].add(from);
      Collections.sort(null);
    }
    for (int i = 0; i < n; i++) {
      if (disc[i] == -1) {
        dfs(i, low, disc, graph, res, i);
      }
    }
    return res;
  }

  private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
    disc[u] = low[u] = ++time; // discover u
    for (int j = 0; j < graph[u].size(); j++) {
      int v = graph[u].get(j);
      if (v == pre) {
        continue; // if parent vertex, ignore
      }
      if (disc[v] == -1) { // if not discovered
        dfs(v, low, disc, graph, res, u);
      }

      low[u] = Math.min(low[u], low[v]);

      // low[v] > disc[u] means that v has no backward edge that can
      // link v to a vertex that is "lower" (being discovered earlier) than u
      // hence, `(u,v)` is a critical connection
      if (low[v] > disc[u]) {
        res.add(Arrays.asList(u, v));
      }
    }
  }
}