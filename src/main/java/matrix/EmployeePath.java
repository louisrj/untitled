package matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * An employee needs to get to work from home. There is a range that the employee can walk in any direction. There are bus stations on the way to the destination which can the employee can walk to if it is within the walking range and board the bus and get off at the next station. Transit buses can be at the same point or they can be at away from each other. If the next bus station is not at the same spot, then the employee can board the next bus if it is within the walking range. Find out if the employee can get to work or not.
 * For the sake of this question, assume there are no cycles that can form with the bus station and there exists only a single bus station route.
 *
 * Ex: Range that the employee can walk at any point: 5
 * Distance between home to bus station 1 is 1.Employee can take the bus from station 1 and go to station 2. The next bus is that the employee can take is bus station 3 at distance 2. Since it is within walking distance range of 5, he can walk to bus station 3 and take the bus to reach bus station 4. He can then take next bus at the same bus station that drops directly at work.
 * (the points don't necessarily need to have common x or y axis shared between them. It's just easy to illustrate this way as an example)
 *
 *                      * Home
 *
 * 		bus station (1)*--------------------*bus station (2)
 *
 *
 * 																	* bus station (3)
 * 																	|
 * 																	|
 * 																	|
 * 																	|
 * 									  work *------------------------* bus station (4)
 * Important note: there was no defined input parameters for this question. It is upto the programmer to pick and choose data structures that best fit the description of the problem and that will help reach the solution.
 *
 * What would be the best way to solve this?
 */
public class EmployeePath {
  public static void main(String[] args) {
    List<Point> stops = Arrays.asList(new Point(1, 1), new Point(2, 1));
    EmployeePath employeePath = new EmployeePath();
    System.out.println(employeePath.isReachable(new Point(0, 0), new Point(2, 2), stops, 2));
  }

  private boolean isReachable(Point source, Point dest, List<Point> stops, int range) {
    Point prev = source;
    for (Point cur : stops) {
      if (prev != cur && distance(cur, prev) > range)
        return false;
      else
        prev = cur;
    }
    return prev == dest || distance(prev, dest) <= range;
  }

  private boolean isReachableBfs(Point source, Point dest, List<Point> stops, int range) {
    Queue<Point> q = new LinkedList<>();
    q.offer(source);

    while(!q.isEmpty()) {
      Point cur = q.poll();
      if (cur == dest || distance(cur, dest) <= range)
        return true;
      for (Point stop : stops) {
        if (!stop.visited && distance(cur, stop) <= range) {
          stop.visited = true;
          q.add(stop);
        }
      }
    }
    return false;
  }

  private double distance(Point cur, Point stop) {
    return sqrt(pow(cur.x - stop.x, 2) + pow(cur.y - stop.y, 2));
  }

  public static class Point {
    int x;
    int y;
    boolean visited;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
      visited = false;
    }
  }
}
