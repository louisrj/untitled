package array;

import java.util.HashMap;
import java.util.Map;

public class MinimumDominoRotationsForEqualRow {
  public static void main(String[] args) {
    MinimumDominoRotationsForEqualRow m = new MinimumDominoRotationsForEqualRow();
    System.out.println(m.minDominoRotations(new int[]{2, 5, 5, 5, 5}, new int[]{5, 2, 2, 2}));
  }

  /*
Return min number of rotations
if one could make all elements in A or B equal to x.
Else return -1.
*/
  public int check(int x, int[] A, int[] B, int n) {
    // how many rotations should be done
    // to have all elements in A equal to x
    // and to have all elements in B equal to x
    int rotations_a = 0, rotations_b = 0;
    for (int i = 0; i < n; i++) {
      // rotations coudn't be done
      if (A[i] != x && B[i] != x) return -1;
        // A[i] != x and B[i] == x
      else if (A[i] != x) rotations_a++;
        // A[i] == x and B[i] != x
      else if (B[i] != x) rotations_b++;
    }
    // min number of rotations to have all
    // elements equal to x in A or B
    return Math.min(rotations_a, rotations_b);
  }

  public String getHint(String secret, String guess) {
    StringBuilder sb = new StringBuilder();
    int bull = 0, cow = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < secret.length(); i++) {
      map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
    }

    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bull++;
        if (map.containsKey(secret.charAt(i)) && map.get(secret.charAt(i)) == 1)
          map.remove(secret.charAt(i));
        else if (map.containsKey(secret.charAt(i)))
          map.put(secret.charAt(i), map.get(secret.charAt(i)) - 1);
      }
      else if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
        cow++;
        if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) == 1)
          map.remove(guess.charAt(i));
        else if (map.containsKey(guess.charAt(i)))
          map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
      }
    }
    return sb.append(bull).append("A").append(cow).append("B").toString();
  }

  public int minDominoRotations(int[] A, int[] B) {
    int n = A.length;
    int rotations = check(A[0], B, A, n);
    // If one could make all elements in A or B equal to A[0]
    if (rotations != -1 || A[0] == B[0]) return rotations;
      // If one could make all elements in A or B equal to B[0]
    else return check(B[0], B, A, n);
  }
}
