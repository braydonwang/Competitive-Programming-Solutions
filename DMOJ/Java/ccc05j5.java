import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		while (true) {
			String str = next();
			if (str.equals("X")) {
				break;
			}
			if (monkey(str)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	static boolean monkey(String str) {
		if (word(str)) {
			return true;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'N' && word(str.substring(0,i)) && monkey(str.substring(i+1))) {
				return true;
			}
		}
		return false;
	}
	static boolean word(String str) {
		if (str.equals("A")) {
			return true;
		}
		if (str.length() > 2 && str.charAt(0) == 'B' && str.charAt(str.length()-1) == 'S' && monkey(str.substring(1,str.length()-1))){
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
