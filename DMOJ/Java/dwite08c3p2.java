import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int[] num = new int[5];
    for (int i = 0; i < 5; i++){
      String text = sc.nextLine();
      int j = -1;
      int words = 0;
      while (j < text.length()){
        int count = 0;
        while(true){
          j++;
          if (j >= text.length()){
            break;
          }
          if ((text.charAt(j) >= 65 && text.charAt(j) <= 90) || (text.charAt(j) >= 97 && text.charAt(j) <= 122)){
            count++;
          }
          else{
            break;
          }
        }
        if (count > 3){
          words++;
        }
      }
      num[i] = words;
    }
    for (int i = 0; i < 5; i++){
      System.out.println(num[i]);
    }
  }
}
