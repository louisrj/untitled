package array;

import java.util.*;

/**
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Example 3:
 *
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 *
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 *
 * Constraints:
 *
 * 1 <= products.length <= 1000
 * There are no repeated elements in products.
 * 1 <= Σ products[i].length <= 2 * 10^4
 * All characters of products[i] are lower-case English letters.
 * 1 <= searchWord.length <= 1000
 * All characters of searchWord are lower-case English letters.
 *
 */
public class SearchSuggestionSystem {
  public static void main(String[] args) {
    SearchSuggestionSystem searchSuggestionSystem = new SearchSuggestionSystem();
    System.out.println(searchSuggestionSystem.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
  }

  private List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie root = new Trie();
    for (String p : products) { // build Trie.
      Trie t = root;
      for (char c : p.toCharArray()) { // insert current product into Trie.
        if (t.sub[c - 'a'] == null)
          t.sub[c - 'a'] = new Trie();
        t = t.sub[c - 'a'];
        t.suggestion.offer(p); // put products with same prefix into suggestion list.
        Collections.sort(t.suggestion); // sort products.
        if (t.suggestion.size() > 3) // maintain 3 lexicographically minimum strings.
          t.suggestion.pollLast();
      }
    }
    List<List<String>> ans = new ArrayList<>();
    for (char c : searchWord.toCharArray()) { // search product.
      if (root != null) // if current Trie is NOT null.
        root = root.sub[c - 'a'];
      ans.add(root == null ? Collections.emptyList() : root.suggestion); // add it if there exist products with current prefix.
    }
    return ans;
  }

  class Trie {
    Trie[] sub = new Trie[26];
    LinkedList<String> suggestion = new LinkedList<>();
  }

}
