package array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Asked in Microsoft Online test.
 * You are given a string S of length N containing only characters 'a' and 'b'. A substring (contiguous fragment) of S
 * is called a semi-alternating substring if it does not contain three identical consecutive characters. In other words,
 * it does not contain 'aaa' or 'bbb' substrings. Note that S is its own substring:
 *
 * Example:
 *
 * 1. Given s = "baaabbabbb", your function should return 7, which is the length of "aabbabb", the longest
 * semi-alternating substring.
 *
 * 2. Given s = "babba", your function should return 5, since whole S is semi-alternating.
 *
 * 3. Given s = "abaaaa", your function should return 4, because the first four letters of s create a semi-alternating
 * substring.
 *
 * Write an efficeient algorithm for the following assumptions:
 *
 * - N is an integer within the range [1..200,000]
 * - String s consists only of the characters 'a' and/or 'b'
 */
public class LongestConsecutiveSubstringLessThanThree {

  public static void main(String[] args) {
    LongestConsecutiveSubstringLessThanThree l = new LongestConsecutiveSubstringLessThanThree();
    System.out.println(l.lengthOfSubstring("baaabbabbb"));
  }

  private int lengthOfSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('a', 0);
    map.put('b', 0);

    int i = 0, j = 0, res = 0;

    while (i < s.length() && j < s.length()) {
      if (map.get(s.charAt(j)) < 3) {
        map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
        j++;
        res = Math.max(res, j - i);
      } else {
        map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
        i++;
        j++;
      }
    }
    return res;
  }
}
