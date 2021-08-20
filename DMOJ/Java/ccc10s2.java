import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		String output = "";
		String[] letter = new String[n];
		String[] binary = new String[n];
		for (int i = 0; i < n; i++) {
			letter[i] = sc.next();
			binary[i] = sc.next();
		}
		String str = sc.next();
		int i = 0;
		while (i < str.length()) {
			for (int j = 0; j < n; j++) {
				if (str.indexOf(binary[j],i) == i) {
					output = output + letter[j];
					i = i + binary[j].length();
				}
			}
		}
		System.out.println(output);
	}
}
