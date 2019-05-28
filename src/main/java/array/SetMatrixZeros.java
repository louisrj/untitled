package array;


public class SetMatrixZeros {

  public static void main(String[] args) {
    SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
    int[][] matrix = {
        {0, 1, 1, 1},
        {1, 0, 1, 1},
        {1, 1, 0, 1},
        {1, 1, 1, 1}
    };
    setMatrixZeros.setZeroes(matrix);
    setMatrixZeros.print(matrix);
  }

  private void setZeroes(int[][] matrix) {
    boolean firstrow = false, firstCol = false;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (i == 0) firstrow = true;
          if (j == 0) firstCol = true;
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    if (firstrow) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }

    if (firstCol) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
  }

  private void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j]);
        System.out.print("\t");
      }
      System.out.println();
    }
  }
}
