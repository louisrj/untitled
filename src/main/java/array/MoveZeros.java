package array;


import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {

  public static void main(String[] args) {

    int[] nums = {0, 1, 0, 3, 12};
    moveZeros(nums);

    Arrays.stream(nums).forEach(System.out::println);
  }

  private static void moveZeros(int[] nums) {
    int i = 0;

    for (int j = 1; j < nums.length; j++) {
      if (nums[i] == 0 && nums[j] != 0) {
        nums[i] = nums[j];
        nums[j] = 0;
        i++;
      } else if (nums[i] != 0) {
        i++;
      }

    }
  }

}
