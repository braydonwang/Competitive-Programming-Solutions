import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		for (int i = 0; i < n; i++) {
			String a = next(), b = next(), c = next();
			if (a.length() < b.length()) {
				if (b.substring(0,a.length()).equals(a)) {
					System.out.println("No");
					continue;
				}
			} else {
				if (a.substring(0,b.length()).equals(b)) {
					System.out.println("No");
					continue;
				}
			}
			if (a.length() < c.length()) {
				if (c.substring(0,a.length()).equals(a)) {
					System.out.println("No");
					continue;
				}
			} else {
				if (a.substring(0,c.length()).equals(c)) {
					System.out.println("No");
					continue;
				}
			}
			if (c.length() < b.length()) {
				if (b.substring(0,c.length()).equals(c)) {
					System.out.println("No");
					continue;
				}
			} else {
				if (c.substring(0,b.length()).equals(b)) {
					System.out.println("No");
					continue;
				}
			}
			if (a.length() < b.length()) {
				if (b.substring(b.length()-a.length()).equals(a)) {
					System.out.println("No");
					continue;
				}
			} else {
				if (a.substring(a.length()-b.length()).equals(b)) {
					System.out.println("No");
					continue;
				}
			}
			if (c.length() < b.length()) {
				if (b.substring(b.length()-c.length()).equals(c)) {
					System.out.println("No");
					continue;
				}
			} else {
				if (c.substring(c.length()-b.length()).equals(b)) {
					System.out.println("No");
					continue;
				}
			}
			if (a.length() < c.length()) {
				if (c.substring(c.length()-a.length()).equals(a)) {
					System.out.println("No");
					continue;
				}
			} else {
				if (a.substring(a.length()-c.length()).equals(c)) {
					System.out.println("No");
					continue;
				}
			}
			System.out.println("Yes");
		}
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
