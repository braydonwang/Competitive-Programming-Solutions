import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][] dp = new int[2*n][2*n];
		for (int i = 0; i < n; i++) {
			int x = readInt();
			if (x % 2 != 0) {
				dp[i+n][i+n] = 1;
				dp[i][i] = 1;
			}
		}
		for (int l = 2*n-1; l >= 1; l--) {
			for (int r = l; r < 2*n; r++) {
				if (l == r) {
					continue;
				} else {
					dp[l][r] = Math.max(dp[l][l] - dp[l+1][r], dp[r][r] - dp[l][r-1]);
				}
			}
		}
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (dp[i][i] - dp[i+1][i+n-1] > 0) {
				count++;
			}
		}
		System.out.println(count);
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
