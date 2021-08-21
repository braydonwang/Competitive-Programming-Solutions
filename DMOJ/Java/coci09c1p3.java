import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long count;
	public static void main(String[] args) throws IOException {
		String str = next();
		boolean b = str.indexOf('L') == -1 ? false : true;
		System.out.println(solve(str,b));
	}
	static long solve(String str, boolean good) {
		//System.out.println(str);
		long sum = 0;
		int ind = str.indexOf('_');
		if (ind == -1 && !good) {
			return 0;
		}
		if (ind == -1) {
			for (int i = 1; i < str.length()-2; i++) {
				if ((isVowel(str.charAt(i)) && isVowel(str.charAt(i+1)) && isVowel(str.charAt(i-1)) || (isConsonant(str.charAt(i)) && isConsonant(str.charAt(i+1)) && isConsonant(str.charAt(i-1))))){
					return 0;
				}
			}
			//System.out.println(str.charAt(6) + "" + str.charAt(9) +"" + str.charAt(14)+"" + str.charAt(15) + "" + "" + str.charAt(16)+ "" + str.charAt(17) + "" + str.charAt(22) + "" + str.charAt(23) + "" + str.charAt(24));
			//System.out.println(str);
			return 1;
		}
		for (int i = 1; i < ind-1; i++) {
			if ((isVowel(str.charAt(i)) && isVowel(str.charAt(i+1)) && isVowel(str.charAt(i-1)) || (isConsonant(str.charAt(i)) && isConsonant(str.charAt(i+1)) && isConsonant(str.charAt(i-1))))){
				return 0;
			}
		}
		if (ind == 0) {
			if (!(isVowel(str.charAt(ind+1)) && isVowel(str.charAt(ind+2)))) {
				sum += 5 * solve('A' + str.substring(ind+1),good);
			}
			if (!(isConsonant(str.charAt(ind+1)) && isConsonant(str.charAt(ind+2)))) {
				sum += 20 * solve('C' + str.substring(ind+1),good);
				sum += solve('L' + str.substring(ind+1),true);
			}
		} else if (ind == str.length()-1) {
			if (!(isVowel(str.charAt(ind-1)) && isVowel(str.charAt(ind-2)))) {
				sum += 5 * solve(str.substring(0,ind) + 'A',good);
			}
			if (!(isConsonant(str.charAt(ind-1)) && isConsonant(str.charAt(ind-2)))) {
				sum += 20 * solve(str.substring(0,ind) + 'C',good);
				sum += solve(str.substring(0,ind) + 'L',true);
			}
		} else {
			if (!(isVowel(str.charAt(ind-1)) && isVowel(str.charAt(ind+1)))) {
				sum += 5 * solve(str.substring(0,ind) + 'A' + str.substring(ind+1),good);
			}
			if (!(isConsonant(str.charAt(ind-1)) && isConsonant(str.charAt(ind+1)))) {
				sum += 20 * solve(str.substring(0,ind) + 'C' + str.substring(ind+1),good);
				sum += solve(str.substring(0,ind) + 'L' + str.substring(ind+1),true);
			}
		}
		return sum;
	}
	static boolean isVowel(char ch) {
		if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
			return true;
		}
		return false;
	}
	static boolean isConsonant(char ch) {
		if (ch == 'B' || ch == 'C' || ch == 'D' || ch == 'F' || ch == 'G' || ch == 'H' || ch == 'J' || ch == 'K' || ch == 'L' || ch == 'M' || ch == 'N' || ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S' || ch == 'T' || ch == 'V' || ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z') {
			return true;
		}
		return false;
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
