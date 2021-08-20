import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			n = readInt(); k = readInt();
			System.out.println("The bit patterns are");
			solve("", k);
			System.out.println();
		}
	}
	static void solve(String s, int x) {
		if (s.length() == n) {
			System.out.println(s);
			return;
		}
		if (x == 0) {
			solve(s+"0",x);
		} else if (n-s.length() == x) {
			solve(s+"1",x-1);
		} else {
			solve(s+"1",x-1);
			solve(s+"0",x);
		}
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
