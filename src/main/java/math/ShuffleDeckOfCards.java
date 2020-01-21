package math;

import java.util.Random;

public class ShuffleDeckOfCards {
  public static void main(String[] args) {
    int[] a = new int[52];
    for (int i = 0; i < 52; i++) {
      a[i] = i;
    }

    shuffle(a);

    System.out.println(a);


  }

  private static void shuffle(int[] a) {
    Random random = new Random();

    for (int i =0; i < 52; i++) {
      int r = random.nextInt(52 - i);
      int rand = (int)(Math.random()*(i+1));

      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }
}
