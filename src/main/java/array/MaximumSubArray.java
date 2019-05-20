package array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 * 
 * Example:
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubArray {

  public static void main(String[] args) {

    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(arr));
  }

  private static int maxSubArray(int[] a) {
    int currentMax = a[0], globalMax = a[0];

    for (int i = 1; i < a.length; i++) {
      currentMax = Math.max(a[i], currentMax + a[i]);
      globalMax = Math.max(currentMax, globalMax);
    }
    return globalMax;
  }

}
