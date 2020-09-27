package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Similar questions:
 * LC#33, LC#81, LC#153, LC#154
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0 Output: 4 Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3 Output: -1
 */
public class SearchInRotatedSortedArray {


  public static void main(String[] args) {
    SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
    System.out.println(s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
  }

  private int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while(low < high) {
      int mid = (low + high) / 2;
      if (nums[mid] > nums[high])
        low = mid + 1;
      else
        high = mid;
    }

    int rotateIndex = low;
    low = 0;
    high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;
      int realMid = (rotateIndex + mid) % nums.length - 1;
      if (nums[realMid] == target) return realMid;
      if (nums[realMid] > target)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return -1;
  }
}
