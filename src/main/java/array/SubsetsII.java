package array;

import java.util.*;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {
  public static void main(String[] args) {
    SubsetsII s = new SubsetsII();
    List<List<Integer>> lists = s.subsetsWithDup(new int[]{1, 2, 2});
    lists.forEach(System.out::println);
  }

  private List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> lists = new ArrayList<>();
    Arrays.sort(nums);
    helper(0, new ArrayList<>(), nums, lists);
    return lists;
  }

  private void helper(int start, List<Integer> list, int[] nums, List<List<Integer>> lists) {
    lists.add(new ArrayList<>(list));


    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      list.add(nums[i]);
      helper(i + 1, list, nums, lists);
      list.remove(list.size() - 1);
    }
  }
}
