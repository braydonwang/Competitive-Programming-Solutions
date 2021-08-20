import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			String mod = "";
			char ch = str.charAt(0);
			int count = 1;
			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j) == ch) {
					count++;
				}
				else {
					mod = mod + count + " " + ch + " ";
					count = 1;
					ch = str.charAt(j);
				}
			}
			mod = mod + count + " " + ch + " ";
			System.out.println(mod);
		}
    }
}
