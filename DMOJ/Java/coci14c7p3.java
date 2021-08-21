import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] array;
	public static void main(String[] args) throws IOException {
		n = readInt();
		array = new int[3][n+1];
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= n; j++) {
				array[i][j] = readInt();
			}
		}
		System.out.println(Math.min(solve(0,1,2), Math.min(solve(0,2,1), Math.min(solve(1,0,2), Math.min(solve(1,2,0), Math.min(solve(2,0,1), solve(2,1,0)))))));
	}
	static int solve(int a, int b, int c) {
		int[][] dp = new int[n+1][3];
		dp[1][a] = array[a][1];
		dp[2][b] = array[a][1] + array[b][2];
		dp[3][c] = array[a][1] + array[b][2] + array[c][3];
		for (int i = 1; i <= n; i++) {
			if (i != 1) {
				dp[i][a] = dp[i-1][a] + array[a][i];
			}
			if (i > 2) {
				dp[i][b] = Math.min(dp[i-1][a], dp[i-1][b]) + array[b][i];
			}
			if (i > 3) {
				dp[i][c] = Math.min(dp[i-1][b], dp[i-1][c]) + array[c][i];
			}
		}
		return dp[n][c];
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
