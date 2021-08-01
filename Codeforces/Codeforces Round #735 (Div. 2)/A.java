import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int i = 0; i < t; i++) {
			int n = readInt();
			long[] a = new long[n+1];
			long max = 0;
			for (int j = 1; j <= n; j++) {
				a[j] = readInt();
			}
			for (int j = 1; j < n; j++) {
				max = Math.max(max, a[j]*a[j+1]);
			}
			System.out.println(max);
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
