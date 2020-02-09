package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 *
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class WordBreakII {
  HashMap<String, List<String>> map = new HashMap<>();

  public static void main(String[] args) {
    WordBreakII wordBreakII = new WordBreakII();
    System.out.println(wordBreakII.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
  }

  private List<String> wordBreak(String s, List<String> wordDict) {
    List<String> res = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return res;
    }
    if (map.containsKey(s)) {
      return map.get(s);
    }
    if (wordDict.contains(s)) {
      res.add(s);
    }
    for (int i = 1; i < s.length(); i++) {
      String t = s.substring(i);
      if (wordDict.contains(t)) {
        List<String> temp = wordBreak(s.substring(0, i), wordDict);
        if (temp.size() != 0) {
          for (String value : temp) {
            res.add(value + " " + t);
          }
        }
      }
    }
    map.put(s, res);
    return res;
  }
}
