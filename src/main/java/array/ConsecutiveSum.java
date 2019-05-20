package array;


/**
 * Question asked in discover ol
 */
public class ConsecutiveSum {

  public static void main(String[] args) {

    System.out.println(consecutive(21));
  }

  private static int consecutive(long num) {
    // Write your code here


    if (num == 1 || num == 2) {
      return 0;
    }

    int count = 0;

    for (int i = 1; i <= (num / 2) + 1; i++) {
      long sum = 0;
      for (int j = i; j <= (num / 2) + 1; j++) {
        sum = sum + j;
        if (sum > num) {
          break;
        } else if (sum == num) {
          count++;
          break;
        }
      }
    }

    return count;
  }

}
