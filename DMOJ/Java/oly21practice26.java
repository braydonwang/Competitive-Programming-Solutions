import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] x = new int[n], y = new int[n], w = new int[n], h = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = readInt(); y[i] = readInt(); w[i] = readInt(); h[i] = readInt();
		}
		int p = readInt(), q = readInt();
		for (int i = n-1; i >= 0; i--) {
			if (p >= x[i] && p <= x[i] + w[i] && q >= y[i] && q <= y[i] + h[i]) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println(-1);
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
