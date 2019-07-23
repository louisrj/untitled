package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question asked in discover ol
 */
public class SortDates {

  public static void main(String[] args) {

    List<String> input = new ArrayList<>();

    input.add("20 Oct 2052");
    input.add("06 Jun 1960");
    input.add("26 May 1960");
    input.add("20 Sep 1958");
    input.add("16 Mar 2068");
    input.add("25 May 1912");

    List<String> strings = sortDates(input);

    strings.forEach(System.out::println);
    System.out.println();
    input.forEach(System.out::println);

  }

  private static List<String> sortDates(List<String> dates) {


    dates.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        Map<String, Integer> map = new HashMap<>();

        map.put("Jan", 1);
        map.put("Feb", 2);
        map.put("Mar", 3);
        map.put("Apr", 4);
        map.put("May", 5);
        map.put("Jun", 6);
        map.put("Jul", 7);
        map.put("Aug", 8);
        map.put("Sep", 9);
        map.put("Oct", 10);
        map.put("Nov", 11);
        map.put("Dec", 12);
        String[] s1 = o1.split(" ");
        String[] s2 = o2.split(" ");
        String yearString1 = s1[2];
        String yearString2 = s2[2];
        Integer year1 = Integer.valueOf(yearString1);
        Integer year2 = Integer.valueOf(yearString2);
        if (year1 < year2) {
          return -1;
        } else if (year1 > year2) {
          return 1;
        } else {
          String m1 = s1[1];
          String m2 = s2[1];

          Integer mon1 = map.get(m1);
          Integer mon2 = map.get(m2);

          if (mon1 < mon2) {
            return -1;
          } else if (mon1 > mon2) {
            return 1;
          } else {
            String d1 = s1[0];
            String d2 = s2[0];

            Integer date1 = Integer.valueOf(d1);
            Integer date2 = Integer.valueOf(d2);

            if (date1 < date2) {
              return -1;
            } else if (date1 > date2) {
              return 1;
            } else {
              return 0;
            }

          }
        }
      }
    });

    return dates;


  }
}
