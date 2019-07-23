package strings;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
 * read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code). You may assume all tickets form at least one valid
 * itinerary. Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]] Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]] Output:
 * ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class ReconstructItinerary {

  private Map<String, PriorityQueue<String>> flights;
  private LinkedList<String> path;

  public static void main(String[] args) {
    ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
    List<List<String>> tickets = new ArrayList<>();

    List<String> t1 = Arrays.asList("JFK", "SFO");
    tickets.add(t1);

    List<String> t2 = Arrays.asList("JFK", "ATL");
    tickets.add(t2);

    List<String> t3 = Arrays.asList("SFO", "ATL");
    tickets.add(t3);

    List<String> t4 = Arrays.asList("ATL", "JFK");
    tickets.add(t4);

    List<String> t5 = Arrays.asList("ATL", "SFO");
    tickets.add(t5);

    System.out.println(reconstructItinerary.findItinerary(tickets));
  }

  private List<String> findItinerary(List<List<String>> tickets) {
    flights = new HashMap<>();
    path = new LinkedList<>();

    tickets.forEach(ticket -> {
      flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
      flights.get(ticket.get(0)).add(ticket.get(1));

    });
    dfs("JFK");

    Stack<Character> stack = new Stack<>();


    return path;
  }

  private void dfs(String departure) {
    PriorityQueue<String> arrivals = flights.get(departure);
    while (arrivals != null && !arrivals.isEmpty())
      dfs(arrivals.poll());
    path.addFirst(departure);
  }
}
