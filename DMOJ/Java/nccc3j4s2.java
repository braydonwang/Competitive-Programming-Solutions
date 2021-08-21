import java.util.Scanner;
import java.util.Arrays;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    int[][] num = new int[n][n];
    int[] medians = new int[n];
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        num[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < n; i++){
      Arrays.sort(num[i]);
      medians[i] = num[i][n/2];
    }
    Arrays.sort(medians);

    System.out.println(medians[n/2]);
  }
}
