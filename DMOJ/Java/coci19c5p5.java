import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int)1e9+7;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[][] dp = new long[n+1][n+1];
		long[][] c = new long[n+1][n+1];
		long[][] pow = new long[n+1][n+1];
		for (int i = 0; i <= n; i++) {
			pow[i][0] = 1;
			for (int j = 1; j <= n; j++) {
				pow[i][j] = (pow[i][j-1] * i) % mod;
			}
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, n); j++) {
				if (j == 0 || j == i) {
					c[i][j] = 1;
				} else {
					c[i][j] = (c[i-1][j-1] + c[i-1][j]) % mod;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j >= i) {
					dp[i][j] = ((c[j][i] * pow[i-1][j-i]) % mod);
				}
				for (int k = 0; k <= j; k++) {
					if (k == i) {
						continue;
					}
					dp[i][j] = ((dp[i][j] + (c[j][k] * dp[i-1][j-k]) % mod) % mod);
				}
			}
		}
		System.out.println(dp[n][n]);
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
