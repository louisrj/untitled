package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumEqualsKPrint {
  public static void main(String[] args) {
    System.out.println(subArrayEqualsK(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
  }

  private static List<List<Integer>> subArrayEqualsK(int[] nums, int k) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0,-1);
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        Integer integer = map.get(sum - k);
        List<Integer> list = new ArrayList<>();
        for (int j = integer + 1; j <= i; j++) {
          list.add(nums[j]);
        }
        result.add(list);
      }
      map.put(sum, i);
    }

    return result;
  }
}
