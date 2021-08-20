import java.util.*;
public class Main {
  public static boolean palindrome(String text){
    for (int i = 0; i < text.length()/2; i++){
      if (text.charAt(i) != text.charAt(text.length()-i-1)){
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    ArrayList<Integer> list=new ArrayList<Integer>();
    String text = sc.nextLine();
    for (int i = 0; i < text.length(); i++){
      for (int j = i+1; j <= text.length(); j++){
        if (palindrome(text.substring(i,j))){
          list.add(text.substring(i,j).length());
        }
      }
    }
    Collections.sort(list);
    System.out.println(list.get(list.size()-1));
  }
}
