import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    for(int i = 1; i <= n; i++){
      String num = sc.next(); int sum = 0;
      for(int j=0; j<num.length(); j++){
        sum = sum + num.charAt(j) - '0';
        if (sum >= 10) sum = sum/10 + sum%10;
      }
      System.out.println(sum);
    }
  }
}
