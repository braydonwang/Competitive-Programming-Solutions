import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    int star = 1;
    int space = n*2-2;
    for (int i = 0; i < n/2+1; i++){
      for (int j = 0; j < star; j++){
        System.out.print("*");
      }
      for (int k = 0; k < space; k++){
        System.out.print(" ");
      }
      for (int h = 0; h < star; h++){
        System.out.print("*");
      }
      star = star + 2;
      space = space - 4;
      System.out.println();
    }
    space = space + 8;
    star = star - 4;
    for (int i = 0; i < n/2; i++){
      for (int j = 0; j < star; j++){
        System.out.print("*");
      }
      for (int k = 0; k < space; k++){
        System.out.print(" ");
      }
      for (int h = 0; h < star; h++){
        System.out.print("*");
      }
      star = star - 2;
      space = space + 4;
      System.out.println();
    }
  }
}
