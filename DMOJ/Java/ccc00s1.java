import java.util.Arrays;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    int count = 0;
    Scanner sc = new Scanner (System.in);
    int money = sc.nextInt();
    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    int n3 = sc.nextInt();
    while (money > 0){
      count = count + 1;
      money = money - 1;
      if ((count + 2) % 3 == 0){
        n1 = n1 + 1;
        if (n1 == 35){
          money = money + 30;
          n1 = 0;
        }
      }
      if ((count + 1) % 3 == 0){
        n2 = n2 + 1;
        if (n2 == 100){
          money = money + 60;
          n2 = 0;
        }
      }
      if (count % 3 == 0){
        n3 = n3 + 1;
        if (n3 == 10){
          money = money + 9;
          n3 = 0;
        }
      }
    }
    System.out.println("Martha plays " + count + " times before going broke.");
  }
}
