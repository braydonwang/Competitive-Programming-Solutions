import java.util.*;
public class Main {
  public static String convert(char ch){
    String num = "0";
    if (ch == '1'){
      num = "1";
    }
    else if (ch == '2' || ch == 'A' || ch == 'B' || ch == 'C'){
      num = "2";
    }
    else if(ch == '3' || ch == 'D' || ch == 'E' || ch == 'F'){
      num = "3";
    }
    else if(ch == '4' || ch == 'G' || ch == 'H' || ch == 'I'){
      num = "4";
    }
    else if(ch == '5' || ch == 'J' || ch == 'K' || ch == 'L'){
      num = "5";
    }
    else if(ch == '6' || ch == 'M' || ch == 'N' || ch == 'O'){
      num = "6";
    }
    else if(ch == '7'|| ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S'){
      num = "7";
    }
    else if(ch == '8' || ch == 'T' || ch == 'U' || ch == 'V'){
      num = "8";
    }
    else if(ch == '9' || ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z'){
      num = "9";
    }
    else if(ch == '0'){
      num = "0";
    }
    else{
      num = "";
    }
    return num;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int n = sc.nextInt();
    String[] num = new String[n];
    sc.nextLine();
    for (int i = 0; i < n; i++){
      String number = "";
      int j = 0;
      String text = sc.nextLine();
      while (number.length() < 12){
        number = number + convert(text.charAt(j));
        if (number.length() == 3 || number.length() == 7){
          number = number + "-";
        }
        j++;
      }
      num[i] = number;
    }
    for (int i = 0; i < n; i++){
      System.out.println(num[i]);
    }
  }
}
