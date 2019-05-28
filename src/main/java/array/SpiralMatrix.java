package array;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output: [1,2,3,6,9,8,7,4,5] Example 2:
 *
 * Input: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
  public static void main(String[] args) {
    SpiralMatrix s = new SpiralMatrix();
    int[][] matrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    List<Integer> ints = s.spiralOrder(matrix);
    for (Integer i : ints) {
      System.out.print(i + "\t");
    }
  }

  private List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return res;
    }

    int rowStart = 0;
    int rowEnd = matrix.length;
    int colStart = 0;
    int colEnd = matrix[0].length;

    while (rowStart < rowEnd && colStart < colEnd) {
      for (int i = colStart; i < colEnd; i++) {
        res.add(matrix[rowStart][i]);
      }
      rowStart++;

      for (int i = rowStart; i < rowEnd; i++) {
        res.add(matrix[i][colEnd - 1]);
      }
      colEnd--;

      if (rowStart < rowEnd) {
        for (int i = colEnd - 1; i >= colStart; i--) {
          res.add(matrix[rowEnd - 1][i]);
        }
      }
      rowEnd--;

      if (colStart < colEnd) {
        for (int i = rowEnd - 1; i >= rowStart; i--) {
          res.add(matrix[i][colStart]);
        }
      }
      colStart++;
    }
    return res;
  }
}
