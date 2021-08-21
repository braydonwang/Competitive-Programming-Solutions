import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp;
	static int n;
	static int[][] p;
	public static void main(String[] args) throws IOException {
		n = readInt();
		dp = new int[n+1][2];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
	    p = new int[n+1][2];
		for (int i = 1; i <= n; i++) {
			p[i][0] = readInt(); p[i][1] = readInt();
		}
		p[0][0] = p[1][0]; p[0][1] = p[1][1];
		System.out.println(Math.min(solve(0,1) + p[1][0] - 1, solve(1,1) + p[1][1] - 1) + n - 1);
	}
	static int solve(int pos, int ind) {
		if (dp[ind][pos] != Integer.MAX_VALUE) {
			return dp[ind][pos];
		}
		if (ind == n) {
			return Math.abs(p[ind-1][pos] - p[n][0]) + n - p[n][0];
		}
		dp[ind][pos] = Math.min(Math.abs(p[ind][1] - p[ind-1][pos]) + p[ind][1] - p[ind][0] + solve(0,ind+1), Math.abs(p[ind-1][pos] - p[ind][0]) + p[ind][1] - p[ind][0] + solve(1,ind+1));
		//System.out.println(dp[ind][pos] + " " + p[ind-1][pos] + " " + ind);
		return dp[ind][pos];
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
