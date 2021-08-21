import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int[] days = new int[5];
    int[] months = new int[5];
    int[] years = new int[5];
    boolean[] old = new boolean[5];
    for (int i = 0; i < 5; i++){
      days[i] = sc.nextInt();
      months[i] = sc.nextInt();
      years[i] = sc.nextInt();
      old[i] = false;
    }
    for (int i = 0; i < 5; i++){
      if (years[i] < 1997){
        old[i] = true;
      }
      else{
        if (years[i] == 1997 && months[i] < 10){
          old[i] = true;
        }
        else{
          if (years[i] == 1997 && months[i] == 10 && days[i] <= 27){
            old[i] = true;
          }
        }
      }
    }
    for (int i = 0; i < 5; i++){
      if (old[i] == true){
        System.out.println("old enough");
      }
      else{
        System.out.println("too young");
      }
    }
  }
}
