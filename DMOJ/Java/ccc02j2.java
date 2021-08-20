import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		ArrayList<Character> list=new ArrayList<Character>();
		list.add('a'); list.add('e'); list.add('i'); list.add('o'); list.add('u'); list.add('y');
		while (true) {
			String str = sc.next();
			if (str.equals("quit!")) {
				break;
			}
			else if (str.length() > 4 && str.charAt(str.length()-1) == 'r' && str.charAt(str.length()-2) == 'o' && !list.contains(str.charAt(str.length()-3))){
				System.out.println(str.substring(0,str.length()-2) + "our");
			}
			else {
				System.out.println(str);
			}
		}
    }
}
