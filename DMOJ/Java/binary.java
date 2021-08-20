import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++){
      int num = sc.nextInt();
      int count = 0;
      String binary = "";
      if (num == 0){
        System.out.println("0000");
        continue;
      }
      while (true){
        if (num > Math.pow(2,count)){
          count++;
        }
        else if (num == Math.pow(2,count)){
          break;
        }
        else{
          count--;
          break;
        }
      }
      if ((count + 1) % 4 == 1){
        binary += "000";
      }
      else if ((count + 1) % 4 == 2){
        binary += "00";
      }
      else if ((count + 1) % 4 == 3){
        binary += "0";
      }
      int spaces = 0;
      for (int j = count; j >= 0; j--) {
        if (num - Math.pow(2,j) >= 0){
          num = (int) (num - Math.pow(2,j));
          binary += "1";
        }
        else{
          binary += "0";
        }
        if ((binary.length() - spaces) % 4 == 0){
          binary += " ";
          spaces++;
        }
      }
      System.out.println(binary);
    }
    sc.close();
  }
}
