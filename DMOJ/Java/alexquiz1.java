import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt(), k = readInt();
		int[] p = new int[n];
		long[] s = new long[n];
		for (int i = 0; i < n; i++) {
			p[i] = readInt(); s[i] = readInt();
		}
		long[] dp = new long[k+1];
		for (int i = 0; i < n; i++) {
			for (int j = p[i]; j <= k; j++) {
				dp[j] = Math.max(dp[j], dp[j-p[i]] + s[i]);
			}
		}
		for (int i = 0; i < m; i++) {
			int q = readInt(), t = readInt(), d = readInt(), a = readInt();
			long sat = q * s[t-1];
			for (int j = 1; a - j >= 0; j*=2) {
				for (int l = k; l >= d*j; l--) {
					dp[l] = Math.max(dp[l], dp[l-d*j] + sat*j);
				}
				a -= j;
			}
			if (a > 0) {
				for (int l = k; l >= d*a; l--) {
					dp[l] = Math.max(dp[l], dp[l-d*a] + sat*a);
				}
			}
		}
		System.out.println(dp[k]);
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
