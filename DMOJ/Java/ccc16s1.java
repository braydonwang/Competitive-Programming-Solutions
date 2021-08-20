import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String text1 = sc.nextLine();
		String text2 = sc.nextLine();
		int count1 = 0;
		int count2 = 0;
		boolean n = false;
		for (int i = 0; i < text1.length(); i++) {
			count1 = 0;
			count2 = 0;
			for (int j = 0; j < text1.length(); j++) {
				if (text2.charAt(i) != '*') {
					if (text2.charAt(i) == text2.charAt(j)) {
						count2++;
					}
					if (text2.charAt(i) == text1.charAt(j)) {
						count1++;
					}
				}
			}
			if (count1 < count2) {
				n = true;
				break;
			}
		}
		if (n) {
			System.out.println("N");
		}
		else {
			System.out.println("A");
		}
	}
}
