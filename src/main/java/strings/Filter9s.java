package strings;

/**
 * checkCastOut9s
 *
 * f(n1) + f(n2) = f(n1 + n2) For example, n1 = 14951, n2 = 23123, n1+n2 = 38075
 *
 * 14952 -> 12 -> 3 + 23123 -> 11 -> 2 ---------- 38075 -> 23 -> 5
 */
public class Filter9s {
  public static void main(String[] args) {
    System.out.println("Hello World");
    System.out.println("checkCastOut9s=" + checkCastOut9s(14952, 23123));  // should return true
  }

  private static boolean checkCastOut9s(int n1, int n2) {
    // implement function here
    int res = n1 + n2;
    int parsedN1 = recursiveHelperSum(n1);
    System.out.println(parsedN1);
    int parsedN2 = recursiveHelperSum(n2);
    System.out.println(parsedN2);
    int parsedRes = recursiveHelperSum(res);
    System.out.println(parsedRes);
    return parsedN1 + parsedN2 == parsedRes;
  }


//Recursive helper

  private static int recursiveHelperSum(int num) {
    if (num < 10) return num;
    num = checkCastOut9sHelper(num);
    return recursiveHelperSum(num);
  }

  private static int checkCastOut9sHelper(int n) {
    String str = String.valueOf(n);
    str = str.replaceAll("9", "");

    int sum = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - '0';
      sum = sum + val;
    }
    return sum;
  }
}