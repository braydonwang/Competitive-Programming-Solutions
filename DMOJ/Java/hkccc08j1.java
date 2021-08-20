import java.util.Arrays;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int c = sc.nextInt();
    int[] casper = new int[c];
    for (int i = 0; i < c; i++){
      int weight = sc.nextInt();
      int length = sc.nextInt();
      casper[i] = weight*length;
    }
    int n = sc.nextInt();
    int[] natalie = new int[n];
    for (int i = 0; i < n; i++){
      int weight = sc.nextInt();
      int length = sc.nextInt();
      natalie[i] = weight*length;
    }

    Arrays.sort(casper);
    Arrays.sort(natalie);

    if (casper[c-1] > natalie[n-1]){
      System.out.println("Casper");
    }
    if (casper[c-1] < natalie[n-1]){
      System.out.println("Natalie");
    }
    if (casper[c-1] == natalie[n-1]){
      System.out.println("Tie");
    }
  }
}
