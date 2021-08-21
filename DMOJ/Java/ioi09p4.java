import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][][][] dp;
	static int[][] pre;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		pre = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				pre[i][j] = readInt() + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
			}
		}
		dp = new int[n+1][n+1][m+1][m+1];
		System.out.println(solve(1,n,1,m));
	}
	static int solve(int l, int r, int ll, int rr) {
		if (dp[l][r][ll][rr] != 0) {
			return dp[l][r][ll][rr];
		}
		if (l == r && ll == rr) {
			return 0;
		}
		dp[l][r][ll][rr] = Integer.MAX_VALUE;
		int num = sum(l,r,ll,rr);
		for (int a = l; a < r; a++) {
			dp[l][r][ll][rr] = Math.min(dp[l][r][ll][rr], solve(l,a,ll,rr) + solve(a+1,r,ll,rr) + num);
		}
		for (int a = ll; a < rr; a++) {
			dp[l][r][ll][rr] = Math.min(dp[l][r][ll][rr], solve(l,r,ll,a) + solve(l,r,a+1,rr) + num);
		}
		return dp[l][r][ll][rr];
	}
	static int sum(int a, int b, int c, int d) {
		return pre[b][d] - pre[a-1][d] - pre[b][c-1] + pre[a-1][c-1];
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
