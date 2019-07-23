package graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

  public static void main(String[] args) {
    CourseSchedule schedule = new CourseSchedule();
    System.out.println(schedule.canFinish(4, new int[][]{{1, 0}, {1, 2}, {1, 3}, {2, 3}}));
  }

  private boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; //??

    // create the array lists to represent the courses
    List<List<Integer>> courses = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++) {
      courses.add(new ArrayList<>());
    }

    // create the dependency graph
    for (int i = 0; i < prerequisites.length; i++) {
      courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }

    int[] visited = new int[numCourses];

    // dfs visit each course
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, courses, visited)) return false;
    }

    return true;
  }

  private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {

    visited[course] = 1; // mark it being visited

    List<Integer> eligibleCourses = courses.get(course); // get its children

    // dfs its children
    for (int i = 0; i < eligibleCourses.size(); i++) {
      int eligibleCourse = eligibleCourses.get(i);

      if (visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
      if (visited[eligibleCourse] == 0) { // not visited
        if (!dfs(eligibleCourse, courses, visited)) return false;
      }

    }
    visited[course] = 2; // mark it done visiting
    return true;
  }
}
