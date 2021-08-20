import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String text1 = sc.nextLine();
		String text2 = sc.nextLine();
		String a = text1.replaceAll(" ", "");
		String b = text2.replaceAll(" ", "");
		char[] ch1 = new char[a.length()];
		char[] ch2 = new char[b.length()];
		for (int i = 0; i < a.length(); i++) {
			ch1[i] = a.charAt(i);
			ch2[i] = b.charAt(i);
		}
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		if (Arrays.equals(ch1, ch2)) {
			System.out.println("Is an anagram.");
		}
		else {
			System.out.println("Is not an anagram.");
		}
	}
}
