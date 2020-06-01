package strings;

public class ReverseString {
  public static void main(String[] args) {
    ReverseString reverseString = new ReverseString();
    System.out.println(reverseString.reverseString("abc"));

  }

  private String reverseString(String input) {
    return reverseHelper("", input);
  }

  private String reverseHelper(String prefix, String input) {
    if (input.length() == 0) return prefix;

    for (int i = 0; i < input.length(); i++) {
      prefix = reverseHelper(input.charAt(i) + prefix, input.substring(i + 1));
    }
    return prefix;
  }
}
