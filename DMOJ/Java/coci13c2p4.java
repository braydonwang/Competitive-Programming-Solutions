import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp;
	static int[][] a;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = readInt();
			}
		}
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		System.out.println(solve(0,0));
	}
	static int solve(int l, int r) {
		int cur = Math.max(l, r) + 1;
		if (cur == n) {
			return 0;
		}
		if (dp[l][r] != Integer.MAX_VALUE) {
			return dp[l][r];
		}
		dp[l][r] = Math.min(solve(cur,r) + a[cur][l], solve(l,cur) + a[cur][r]);
		return dp[l][r];
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
