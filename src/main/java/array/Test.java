package array;

import java.util.*;

public class Test {
  public static void main(String[] args) {
    Map<String, List<String>> map = new HashMap<>();
    List<String> stringList = new ArrayList<>();
    stringList.add("a");
    stringList.add("b");

    map.put("key", stringList);
    map.get("key").add("c");

    for (String str : map.get("key")) {
      System.out.println(str);
    }

    List<String> key = map.get("key");
    key.add("d");

    System.out.println("---------------");
    for (String str : map.get("key")) {
      System.out.println(str);
    }


  }
}
