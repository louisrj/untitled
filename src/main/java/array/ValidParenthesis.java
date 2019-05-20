package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the string: ");
    String next = in.next();
    boolean result = isValid(next);
    System.out.println(result);
  }

  private static boolean isValid(String str) {
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    Stack<Character> stack = new Stack<>();


    char[] chars = str.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (map.containsKey(c)) {
        if (stack.isEmpty() || stack.pop() != map.get(c)) {
          return false;
        }
      } else {
        stack.push(chars[i]);
      }
    }
    return true;
  }
}
