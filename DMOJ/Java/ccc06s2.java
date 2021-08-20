import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		String str = sc.nextLine();
		String a = sc.nextLine(); String b = sc.nextLine();
		for (int i = 0; i < b.length(); i++) {
			char ch = b.charAt(i);
			if (a.indexOf(ch) == -1) {
				System.out.print(".");
			}
			else {
				System.out.print(str.charAt(a.indexOf(ch)));
			}
		}
    }
}
