package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute
 * difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class ContainsDuplicateIII {
  public static void main(String[] args) {
    System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{20,13,4,49, 41,32,9,18}, 2, 3));
  }

//  private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//    if (nums == null || nums.length == 0 || k <= 0) {
//      return false;
//    }
//
//    final TreeSet<Integer> values = new TreeSet<>();
//    for (int ind = 0; ind < nums.length; ind++) {
//
//      final Integer floor = values.floor(nums[ind] + t);
//      final Integer ceil = values.ceiling(nums[ind] - t);
//      if ((floor != null && floor >= nums[ind])
//          || (ceil != null && ceil <= nums[ind])) {
//        return true;
//      }
//
//      values.add(nums[ind]);
//      if (ind >= k) {
//        values.remove(nums[ind - k]);
//      }
//    }
//
//    return false;
//  }

  private long getID(long x, long w) {
    return x < 0 ? (x + 1) / w - 1 : x / w;
  }

  private boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
     if (t < 0) return false;
    Map<Long, Long> d = new HashMap<>();
    long w = (long) t + 1;
    for (int i = 0; i < nums.length; ++i) {
      long m = getID(nums[i], w);
      // check if bucket m is empty, each bucket may contain at most one element
      if (d.containsKey(m))
        return true;
      // check the neighbor buckets for almost duplicate
      if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
        return true;
      if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
        return true;
      // now bucket m is empty and no almost duplicate in neighbor buckets
      d.put(m, (long) nums[i]);
      if (i >= k) d.remove(getID(nums[i - k], w));
    }
    return false;
  }
}
