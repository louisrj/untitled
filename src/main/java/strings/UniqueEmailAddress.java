package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Every email consists of a local name and a domain name, separated by the @ sign.
 *
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 *
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 *
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be
 * forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and
 * "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 *
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain
 * emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not
 * apply for domain names.)
 *
 * It is possible to use both of these rules at the same time.
 *
 * Given a list of emails, we send one email to each address in the list.
 * How many different addresses actually receive mails?
 */
public class UniqueEmailAddress {


  public static void main(String[] args) {
    UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();

    int count = uniqueEmailAddress.numUniqueEmails(
        new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"});

    System.out.println(count);
  }

  private int numUniqueEmails(String[] emails) {

    Set<String> set = new HashSet<>();

    for (String email : emails) {
      String[] strArray = email.split("@");
      String before = strArray[0];
      String after = strArray[1];

      StringBuilder sb = new StringBuilder();
      before = before.replaceAll("\\.", "");
      String[] beforeArray = before.split("\\+");
      String key = beforeArray[0] + "@" + after;
      set.add(key);
    }

    return set.size();
  }
}
