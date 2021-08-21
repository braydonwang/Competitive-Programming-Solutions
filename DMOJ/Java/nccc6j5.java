import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] array = new int[n+1];
		for (int i = 0; i < n; i++) {
			array[readInt()]++;
		}
		long[][] dp = new long[n+1][k+1];
		dp[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i-1][j] + (dp[i-1][j-1] * array[i]) % 998244353) % 998244353;
				}
			}
		}
		System.out.println(dp[n][k]);
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
