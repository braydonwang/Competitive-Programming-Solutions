import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp;
	static int[] p, b;
	static int n, m;
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt(); int k = readInt();
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = readInt();
		}
		b = new int[m+1];
		for (int i = 0; i < m+1; i++) {
			b[i] = readInt();
		}
		dp = new int[n][k+1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(solve(0,k));
	}
	static int solve(int ind, int x) {
		if (ind == n) {
			return 0;
		}
		if (dp[ind][x] != -1) {
			return dp[ind][x];
		}
		for (int i = 0; i <= x && p[ind] + i <= m; i++) {
			dp[ind][x] = Math.max(dp[ind][x], solve(ind+1,x-i) + b[p[ind]+i]);
		}
		return dp[ind][x];
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
