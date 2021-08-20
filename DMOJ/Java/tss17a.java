import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    String[][] name = new String[n][3];
    for (int i = 0; i < n; i++){
      for (int j = 0; j < 3; j++){
        name[i][j] = sc.next();
      }
    }
    for (int i = 0; i < n; i++){
      if (name[i][1].equals(name[i][2])){
        System.out.println(name[i][1]);
      }
      else{
        if (name[i][1].equals(name[i][0])){
        System.out.println(name[i][1]);
        }
        else{
          if (name[i][0].equals(name[i][2])){
            System.out.println(name[i][0]);
          }
          else{
            System.out.println("???");
          }
        }
      }
    }
  }
}
