import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		dp = new long[n+1][n+1];
		System.out.println(solve(1,n));
	}
	static long solve(int l, int r) {
		if (dp[l][r] != 0) {
			return dp[l][r];
		}
		if (l == r) {
			return a[l];
		}
		dp[l][r] = Math.max(a[l] - solve(l+1,r), a[r] - solve(l,r-1));
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
