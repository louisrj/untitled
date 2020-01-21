package strings;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
  public static void main(String[] args) {
    WordLadder wordLadder = new WordLadder();
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//    System.out.println(wordLadder.ladderLength("hit", "cog", wordList));
    System.out.println(wordLadder.ladderLength1("hit", "cog", wordList));
  }

  private int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // Since all words are of same length.
    int length = beginWord.length();

    // Dictionary to hold combination of words that can be formed,
    // from any given word. By changing one letter at a time.
    HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

    wordList.forEach(
        word -> {
          for (int i = 0; i < length; i++) {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);
            ArrayList<String> transformations =
                allComboDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);
          }
        });

    // Queue for BFS
    Queue<Pair<String, Integer>> q = new LinkedList<>();
    q.add(new Pair(beginWord, 1));

    // Visited to make sure we don't repeat processing same word.
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    while (!q.isEmpty()) {
      Pair<String, Integer> node = q.remove();
      String word = node.getKey();
      int level = node.getValue();
      for (int i = 0; i < length; i++) {

        // Intermediate words for current word
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, length);

        // Next states are all the words which share the same intermediate state.
        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
          // If at any point if we find what we are looking for
          // i.e. the end word - we can return with the answer.
          if (adjacentWord.equals(endWord)) {
            return level + 1;
          }
          // Otherwise, add it to the BFS Queue. Also mark it visited
          if (!visited.contains(adjacentWord)) {
            visited.add(adjacentWord);
            q.add(new Pair(adjacentWord, level + 1));
          }
        }
      }
    }

    return 0;
  }

  public int ladderLength1 (String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord))
      return 0;
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    HashSet<String> dict = new HashSet<>(wordList);
    HashSet<String> visited = new HashSet<>();
    visited.add(beginWord);
    int level = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        String s = queue.poll();
        for (int i = 0; i < s.length(); i++) {
          char[] chars = s.toCharArray();
          for (char c = 'a'; c <= 'z'; c++) {
            chars[i] = c;
            String word = new String(chars);
            if (word.equals(endWord))
              return level + 1;
            if (dict.contains(word) && !visited.contains(word)) {
              queue.add(word);
              visited.add(word);
            }
          }
        }
      }
      level++;
    } // while
    return 0;
  }
}
