import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int french = 0;
    int english = 0;
    int n = sc.nextInt();
    String line = sc.nextLine();
    for (int i = 0; i < n; i++){
      line = sc.nextLine();
      for (int j = 0; j < line.length(); j++){
        if (line.charAt(j) == 's' || line.charAt(j) == 'S'){
          french = french + 1;
        }
        else if (line.charAt(j) == 't' || line.charAt(j) == 'T'){
          english = english + 1;
        }
      }
    }
    if (french >= english){
      System.out.println("French");
    }
    else{
      System.out.println("English");
    }
  }
}
