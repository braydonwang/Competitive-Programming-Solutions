import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		String a = next(), b = next();
		int[][] dp = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			dp[i][0] = (i+2) / 3;
		}
		for (int i = 1; i <= m; i++) {
			dp[0][i] = (i+2) / 3;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = Math.max(0, i-3); k <= i-1; k++) {
						min = Math.min(dp[k][j], min);
					}
					for (int k = Math.max(0, j-3); k <= j-1; k++) {
						min = Math.min(dp[i][k], min);
					}
					dp[i][j] = Math.min(min+1, dp[i-1][j-1]+1);
				}
			}
		}
		System.out.println(dp[n][m]);
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
