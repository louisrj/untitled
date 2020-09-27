package array;

/**
 * Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,5,1,8]
 * Output: 18
 * Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
 * Example 2:
 *
 * Input: nums = [4]
 * Output: 0
 * Explanation: Since 4 is not divisible by 3, do not pick any number.
 * Example 3:
 *
 * Input: nums = [1,2,3,4,4]
 * Output: 12
 * Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
public class GreatestSumDivisibleByThree {

  public static void main(String[] args) {
    GreatestSumDivisibleByThree g = new GreatestSumDivisibleByThree();
    System.out.println(g.maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
  }

  public int maxSumDivThree(int[] nums) {
    //init: dp[i] = max sum such that the remainder == i when sum / 3
    //dp[0]=0: max sum such that the remainder == 0 when 0 / 3 is 0
    //dp[1]=-Inf: max sum such that the remainder == 1 when 0 / 3 does not exist
    //dp[2]=-Inf: max sum such that the remainder == 2 when 0 / 3 does not exist
    int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

    for (int num : nums) {
      int[] temp = new int[3];
      //dp transition
      for (int remainder = 0; remainder < 3; remainder++) {
        //updating each remainder for current "num"
        temp[(num + remainder) % 3] = Math.max(dp[(num + remainder) % 3], dp[remainder] + num);
      }
      //rotating array
      dp = temp;
    }
    //return: max sum such that the remainder == 0 when sum / 3
    return dp[0];
  }
}
