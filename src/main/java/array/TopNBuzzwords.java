package array;

import java.util.*;

public class TopNBuzzwords {

  public static void main(String[] args) {

    List<String> possibleFeatures = Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft");
    List<String> featureRequests = Arrays.asList(
        "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
        "The new Elmo dolls are super high quality",
        "Expect the Elsa dolls to be very popular this year, Elsa!",
        "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
        "For parents of older kids, look into buying them a drone",
        "Warcraft is slowly rising in popularity ahead of the holiday season");

    List<String> strings = topBuzzWords(6, 7,possibleFeatures, 6, featureRequests);
    System.out.println(strings);
  }

  private static List<String> topBuzzWords(int numFeatures, int topFeatures, List<String> possibleFeatures, int numFeatureRequests, List<String> featureRequests) {
    if (featureRequests == null || featureRequests.size() == 0) return null;

    Set<String> featureCountMap = new HashSet<>();
    Map<String, Integer> lineCountMap = new HashMap<>();


    for (String possibleFeature : possibleFeatures) {
      featureCountMap.add(possibleFeature.toLowerCase());
      lineCountMap.put(possibleFeature.toLowerCase(), 0);
    }

    for (String featureRequest : featureRequests) {
      Set<String> wordInLine = new HashSet<>();
      String[] words = featureRequest.split("\\W+");
      for (String word : words) {
        if (featureCountMap.contains(word.toLowerCase())) {
          if (!wordInLine.contains(word.toLowerCase())) {
            wordInLine.add(word.toLowerCase());
            lineCountMap.put(word.toLowerCase(), lineCountMap.get(word.toLowerCase()) + 1);
          }
        }
      }
    }

    PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (lineCountMap.get(o1) != lineCountMap.get(o2)) {
          return lineCountMap.get(o1) - lineCountMap.get(o2);
        } else return o1.compareTo(o2);
      }
    });

    if (topFeatures > numFeatures) {
      Map<String, Integer> filteredCountMap = new HashMap<>();
      for (String s : lineCountMap.keySet()) {
        if (lineCountMap.get(s) != 0) {
          filteredCountMap.put(s, lineCountMap.get(s));
        }
      }
      lineCountMap.clear();
      lineCountMap.putAll(filteredCountMap);
    }

    for (String s : lineCountMap.keySet()) {
      queue.add(s);
      if (queue.size() > topFeatures) {
        queue.poll();
      }
    }

    List<String> res = new ArrayList<>();
    for (String s : queue) {
      res.add(0, s);
    }
//    for (int i = result.length - 1; i >= 0; i--) {
//      result[i] = queue.poll();
//      res.add(queue.poll());
//    }

    return res;
  }

}