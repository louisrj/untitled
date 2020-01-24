package array;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {

  public static void main(String[] args) {
    TrappingRainWater trappingRainWater = new TrappingRainWater();
    System.out.println(trappingRainWater.trap(new int[]{1,0,0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }

  private int trap(int[] a) {
    int leftMax = 0;
    int rightMax = 0;
    int left = 0;
    int right = a.length - 1;
    int ans = 0;

    while (left < right) {
      if (a[left] < a[right]) {
        if (a[left] >= leftMax) {
          leftMax = a[left];
        } else {
          ans += (leftMax - a[left]);
        }

        left++;
      } else {
        if (a[right] >= rightMax) {
          rightMax = a[right];
        } else {
          ans += (rightMax - a[right]);
        }
        right--;
      }
    }
    return ans;
  }
}
