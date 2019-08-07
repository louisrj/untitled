package strings;

import java.util.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 *
 * Example:
 *
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class CombinationsOfPhoneNumber {


  private static List<String> output = new ArrayList<>();
  private Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};

  public static void main(String[] args) {

    CombinationsOfPhoneNumber c = new CombinationsOfPhoneNumber();
    c.letterCombinations("23");
    output.forEach(System.out::println);

  }

  private List<String> letterCombinations(String digits) {
    if (digits.length() != 0)
      backtrack("", digits);
    return output;
  }

  private void backtrack(String combination, String next_digits) {
    // if there is no more digits to check
    if (next_digits.length() == 0) {
      // the combination is done
      output.add(combination);
      return;
    }

    // iterate over all letters which map
    // the next available digit
    String digit = next_digits.substring(0, 1);
    String letters = phone.get(digit);
    for (int i = 0; i < letters.length(); i++) {
//        String letter = phone.get(digit).substring(i, i + 1);
//        String letter = String.valueOf(letters.charAt(i));
      char letter = letters.charAt(i);

      // append the current letter to the combination
      // and proceed to the next digits
      backtrack(combination + letter, next_digits.substring(1));
    }
  }
}