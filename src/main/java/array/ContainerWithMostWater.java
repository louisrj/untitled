package array;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    System.out.println(containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  private int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int max = 0;

    while (i < j) {
      max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }

    return max;

  }
}
