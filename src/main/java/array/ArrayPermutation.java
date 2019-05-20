package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class ArrayPermutation {

  public static void main(String[] args) {
    ArrayPermutation ap = new ArrayPermutation();
    List<List<Integer>> permute = ap.permute(new int[]{1, 2, 3});

    permute.forEach(System.out::println);

  }

  private List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), nums);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    }
    for (int num : nums) {
      if (tempList.contains(num)) continue; // element already exists, skip
      tempList.add(num);
      backtrack(list, tempList, nums);
      tempList.remove(tempList.size() - 1);
    }
  }

}
