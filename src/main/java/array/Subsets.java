package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

  public static void main(String[] args) {


    Subsets subsets = new Subsets();
    List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});

    subsets1.forEach(System.out::println);
  }

  private List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();

    if (nums == null || nums.length == 0) {
      return results;
    }

    Arrays.sort(nums);

    List<Integer> subset = new ArrayList<>();
    toFindAllSubsets(nums, results, subset, 0);

    return results;
  }

  private void toFindAllSubsets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex) {
    results.add(new ArrayList<>(subset));
    for (int i = startIndex; i < nums.length; i++) {
      subset.add(nums[i]);
      toFindAllSubsets(nums, results, subset, i + 1);
      subset.remove(subset.size() - 1);
    }
  }
}
