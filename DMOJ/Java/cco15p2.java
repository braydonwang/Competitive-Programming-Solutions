import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] array;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		n = readInt();
		int m = readInt();
		array = new int[n][n];
		for (int i = 0; i < m; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			array[a][b] = c;
		}
		dp = new int[n][1 << n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], (int)-(1e9));
		}
		System.out.println(solve(0,1));
	}
	static int solve(int cur, int mask) {
		if (cur == n-1) {
			return 0;
		}
		if (dp[cur][mask] > 0) {
			return dp[cur][mask];
		}
		for (int i = 1; i < n; i++) {
			if ((mask & (1 << i)) == 0 && array[cur][i] > 0) {
				dp[cur][mask] = Math.max(dp[cur][mask], solve(i,mask + (1 << i)) + array[cur][i]);
			}
		}
		return dp[cur][mask];
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
