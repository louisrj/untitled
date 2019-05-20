package strings;

public class StrStr {

  public static void main(String[] args) {
    StrStr strStr = new StrStr();
    System.out.println(strStr.strStr("aaaaa", "bba"));
  }

  private int strStr(String haystack, String needle) {
    if (haystack == null || needle == null) {
      return -1;
    }

    if (needle.length() == 0) return 0;
    if (needle.length() > haystack.length()) return -1;

    int i = 0;
    while (i <= haystack.length() - needle.length()) {
      int j = 0;
      while (j < needle.length()) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        } else {
          j++;
        }
      }
      if (j == needle.length()) return i;
      i++;
    }
    return -1;

  }
}
