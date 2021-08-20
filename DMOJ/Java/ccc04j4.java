import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		String word = sc.nextLine();
		String str = sc.nextLine();
		String mod = "";
		str = str.replaceAll("[^A-Z]", "");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int index = i % word.length();
			ch = (char) ((((ch - 65) + word.charAt(index) - 65)%26)+65);
			mod = mod + ch;
		}
		System.out.println(mod);
    }
}
