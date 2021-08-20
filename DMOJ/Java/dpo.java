import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dp;
	static int n;
	static int[][] array;
	static int mod;
	public static void main(String[] args) throws IOException {
		n = readInt();
		dp = new int[1 << n];
		mod = (int)(1e9 +7);
		array = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = readInt();
			}
		}
		Arrays.fill(dp, -1);
		System.out.println(fun(0,0));
	}
	static int fun(int man, int mask) {
		if (man == n) {
			return 1;
		}
		if (dp[mask] != -1) {
			return dp[mask];
		}
		dp[mask] = 0;
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) == 0 && array[man][i] == 1) {
				dp[mask] = (dp[mask] + fun(man + 1,mask | (1 << i))) % mod;
			}
		}
		return dp[mask];
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
