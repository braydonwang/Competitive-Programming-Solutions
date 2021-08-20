import java.util.Arrays;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    int smallest = 0;
    int largest = 0;
    int[][] num = new int[n][n];
    int[] corners = new int[4];
    int[][] rotate = new int[n][n];

    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        num[i][j] = sc.nextInt();
      }
    }
    
    corners[0] = num[0][0];
    corners[1] = num[0][n-1];
    corners[2] = num[n-1][0];
    corners[3] = num[n-1][n-1];
    
    Arrays.sort(corners);
    
    for (int count = 0; count < 4; count++){
      int x = 0;
      for (int i = n-1; i > -1; i--){
        for (int j = 0; j < n; j++){
          rotate[x][j] = num[j][i];
        }
        x = x + 1;
      }
      if (rotate[0][0] == corners[0]){
        break;
      }
      else{
        for (int a = 0; a < n; a++){
          for (int b = 0; b < n; b++){
            num[a][b] = rotate[a][b];
          }
        }
      }
    }
    for (int i = 0; i < n; i++){
      for (int j = 0; j < n; j++){
        System.out.print(rotate[i][j] + " ");
      }
      System.out.println();
    }
  }
}
