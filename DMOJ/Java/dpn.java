import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[] array = new long[n+1];
		long[] pre = new long[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readLong();
			pre[i] = array[i] + pre[i-1];
		}
		long[][] dp = new long[n+1][n+1];
		for (int l = n; l >= 1; l--) {
			for (int r = l; r <= n; r++) {
				if (l == r) {
					dp[l][r] = 0;
				} else {
					dp[l][r] = Long.MAX_VALUE;
					for (int i = l; i < r; i++) {
						dp[l][r] = Math.min(dp[l][r], dp[l][i] + dp[i+1][r] + (pre[r]-pre[l-1]));
					}
				}
			}
		}
		System.out.println(dp[1][n]);
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
