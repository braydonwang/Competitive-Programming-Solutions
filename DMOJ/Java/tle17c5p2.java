import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), d = readInt();
		int[] x = new int[n+1];
		for (int i = 1; i <= n; i++) {
			x[i] = readInt();
		}
		int a = Integer.MAX_VALUE, b = Integer.MIN_VALUE, c = Integer.MAX_VALUE, e = Integer.MIN_VALUE;
		for (int i = 0; i < d; i++) {
			int f = readInt(), s = readInt();
			if (x[f] > x[s]) {
				c = Math.min(c, x[s]);
				e = Math.max(e, x[f]);
			} else {
				a = Math.min(a, x[f]);
				b = Math.max(b, x[s]);
			}
		}
		//System.out.println(a + " " + b + " " + c + " " +e);
		if (a == Integer.MAX_VALUE) {
			System.out.println(e - c);
		} else if (c == Integer.MAX_VALUE) {
			System.out.println(b - a);
		} else {
			System.out.println(Math.max(b, e) - Math.min(a, c) + Math.min(Math.max(b, e) - Math.max(a, c),Math.min(b, e) - Math.min(a, c)));
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
