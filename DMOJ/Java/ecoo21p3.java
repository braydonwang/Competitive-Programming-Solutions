import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		int[] a = new int[n+1], ans = new int[n+1];
		Arrays.fill(ans, -1);
		for (int i = 0; i < k; i++) {
			int b = readInt(), c = readInt(), d = readInt();
			if (a[c] < d) {
				a[c] = d;
				ans[c] = b;
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(ans[i] + " ");
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
