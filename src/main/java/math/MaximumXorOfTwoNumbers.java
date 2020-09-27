package math;

public class MaximumXorOfTwoNumbers {
  public static void main(String[] args) {
    MaximumXorOfTwoNumbers m = new MaximumXorOfTwoNumbers();
    System.out.println(m.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
  }

  private int findMaximumXOR(int[] nums) {
    int i = nums[2] ^ nums[3];
    return -1;
  }
}