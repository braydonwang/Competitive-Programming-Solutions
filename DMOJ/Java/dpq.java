import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] bit;
	static int maxn = (int) (2e5+5);
	public static void main(String[] args) throws IOException {
		int n = readInt();
		bit = new long[maxn];
		int[] h = new int[n], a = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = readInt();
		}
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		long[] dp = new long[n];
		long max = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = query(h[i]-1) + a[i];
			update(h[i],dp[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	static void update(int i, long x) {
		for (int j = i; j <= maxn; j += j & (~j+1)) {
			bit[j] = Math.max(bit[j], x);
		}
	}
	static long query(int i) {
		long total = 0;
		for (int j = i; j > 0; j -= j & (~j+1)) {
			total = Math.max(bit[j], total);
		}
		return total;
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
