package array;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has
 * the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubArray {

  public static void main(String[] args) {
    MaximumProductSubArray mps = new MaximumProductSubArray();
    System.out.println(mps.max(new int[]{6, -3, -10, 0, 2}));
  }

  private int max(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }

    int min = arr[0];
    int max = arr[0];
    int ans = arr[0];

    for (int i = 1; i < arr.length; i++) {
      int a = arr[i];
      if (a >= 0) {
        max = Math.max(a, a * max);
        min = Math.min(a, a * min);
      } else {
        int temp = max;
        max = Math.max(a, a * min);
        min = Math.min(a, a * temp);
      }
      ans = Math.max(ans, max);
    }

    return ans;
  }


}
