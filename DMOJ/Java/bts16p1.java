import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		String str = sc.nextLine();
		int upper = 0; int lower = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLowerCase(ch)) {
				lower++;
			}
			else if (Character.isUpperCase(ch)) {
				upper++;
			}
		}
		if (lower > upper) {
			System.out.println(str.toLowerCase());
		}
		else if (lower < upper) {
			System.out.println(str.toUpperCase());
		}
		else {
			System.out.println(str);
		}
    }
}
