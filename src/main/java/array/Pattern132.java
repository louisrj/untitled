package array;

/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 *
 * Note: n will be less than 15,000.
 *
 * Example 1:
 * Input: [1, 2, 3, 4]
 *
 * Output: False
 *
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 *
 * Output: True
 *
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 *
 * Output: True
 *
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class Pattern132 {
  public static void main(String[] args) {
    Pattern132 pattern132 = new Pattern132();
    System.out.println(pattern132.find132pattern(new int[]{3, 1, 4, 2}));
  }

  private boolean find132pattern(int[] nums) {
    if (nums.length < 3)
      return false;
    int[] min = new int[nums.length];
    min[0] = nums[0];
    for (int i = 1; i < nums.length; i++)
      min[i] = Math.min(min[i - 1], nums[i]);
    for (int j = nums.length - 1, k = nums.length; j >= 0; j--) {
      if (nums[j] > min[j]) {
        while (k < nums.length && nums[k] <= min[j])
          k++;
        if (k < nums.length && nums[k] < nums[j])
          return true;
        nums[--k] = nums[j];
      }
    }
    return false;
  }
}
