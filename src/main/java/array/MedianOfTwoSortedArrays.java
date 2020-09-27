package array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
  public static void main(String[] args) {
    MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
    System.out.println(m.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
  }

  private double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //if input1 length is greater than switch them so that input1 is smaller than input2.
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int x = nums1.length;
    int y = nums2.length;

    int low = 0;
    int high = x;
    while (low <= high) {
      int partitionX = (low + high) / 2;
      int partitionY = (x + y + 1) / 2 - partitionX;

      //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
      //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
      int leftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
      int rightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

      int leftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
      int rightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

      if (leftX <= rightY && leftY <= rightX) {
        //We have partitioned array at correct place
        // Now get max of left elements and min of right elements to get the median in case of even length combined array size
        // or get max of left for odd length combined array size.
        if ((x + y) % 2 == 0) {
          return ((double) Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2;
        } else {
          return (double) Math.max(leftX, leftY);
        }
      } else if (leftX > rightY) { //we are too far on right side for partitionX. Go on left side.
        high = partitionX - 1;
      } else { //we are too far on left side for partitionX. Go on right side.
        low = partitionX + 1;
      }
    }

    //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
    throw new IllegalArgumentException();
  }
}
