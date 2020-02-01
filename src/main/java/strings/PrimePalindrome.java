package strings;

import java.util.LinkedList;
import java.util.List;

/**
 * Find the smallest prime palindrome greater than or equal to N.
 *
 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
 *
 * For example, 2,3,5,7,11 and 13 are primes.
 *
 * Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.
 *
 * For example, 12321 is a palindrome.
 *
 *
 *
 * Example 1:
 *
 * Input: 6
 * Output: 7
 * Example 2:
 *
 * Input: 8
 * Output: 11
 * Example 3:
 *
 * Input: 13
 * Output: 101
 *
 *
 * Note:
 *
 * 1 <= N <= 10^8
 * The answer is guaranteed to exist and be less than 2 * 10^8.
 */
public class PrimePalindrome {
  public static void main(String[] args) {
    PrimePalindrome p = new PrimePalindrome();
    System.out.println(p.primePalindrome(12345));
  }

  private int primePalindrome(int n) {
    while (n < Integer.MAX_VALUE) {
      n = nextPalin("" + n);
      if (isPrime(n)) {
        return n;
      }
      n++;
    }
    return -1;
  }

  private int nextPalin(String n) {
    int l = n.length();
    List<Integer> cands = new LinkedList<>();
    int half = Integer.valueOf(n.substring(0, (l + 1) / 2));

    for (int i = half; i <= half + 1; i++) {
      String halfString = "" + i;
      if (l % 2 == 1) {
        halfString = halfString.substring(0, halfString.length() - 1);
      }
      String newString = "" + i + new StringBuilder(halfString).reverse().toString();
      cands.add(Integer.valueOf(newString));
    }

    int ori = Integer.valueOf(n), result = Integer.MAX_VALUE;
    for (int cand : cands) {
      if (cand >= ori && cand < result) {
        result = cand;
      }
    }
    return result;
  }

  private boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    long l = (long) n;
    for (long i = 2; i * i <= l; i++) {
      if (l % i == 0) {
        return false;
      }
    }
    return true;
  }


}
