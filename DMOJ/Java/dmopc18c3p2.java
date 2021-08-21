import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n+1], b = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		for (int i = 1; i <= n; i++) {
			b[i] = readInt();
		}
		int[][] dp = new int[3][n+1];
		for (int i = 1; i <= n; i++) {
			dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1])) + b[i];
			dp[1][i] = dp[0][i-1] + a[i];
			dp[2][i] = dp[1][i-1] + a[i];
		}
		System.out.println(Math.max(dp[0][n], Math.max(dp[1][n], dp[2][n])));
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
