package array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index. Example
 * 2:
 *
 * Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter what. Its maximum jump
 * length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

  public static void main(String[] args) {
    JumpGame jumpGame = new JumpGame();
    System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
  }

  private boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) return false;

    return canJumpHelper(0, nums);
  }

  private boolean canJumpHelper(int pos, int[] nums) {
    if (pos == nums.length - 1) return true;

    int furthestPosition = Math.min(pos + nums[pos], nums.length - 1);

    for (int startIndex = furthestPosition; startIndex > pos; startIndex--) {
      if (canJumpHelper(startIndex, nums)) return true;
    }
    return false;
  }
}
