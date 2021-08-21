import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int x = readInt(), y = readInt();
		int n = readInt(), m = readInt(), c = readInt();
		int l = (int) -1e9, r = (int)1e9, u = (int)1e9, d = (int)-1e9;
		for (int i = 0; i < n; i++) {
			int a = readInt();
			if (a < x && x - a < x - l) {
				l = a;
			} else if (a > x && a - x < r - x) {
				r = a;
			}
		}
		for (int i = 0; i < m; i++) {
			int a = readInt();
			if (a < y && y - a < y - d) {
				d = a;
			} else if (a > y && a - y < u - y) {
				u = a;
			}
		}
		for (int i = 0; i < c; i++) {
			int a = readInt(), b = readInt();
			if (a > l && a < r && b > d && b < u) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
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
