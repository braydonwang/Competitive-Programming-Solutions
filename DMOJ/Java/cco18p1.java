import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		char[] s1 = next().toCharArray();
		int[] a1 = new int[n+1], a2 = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a1[i] = readInt();
		}
		char[] s2 = next().toCharArray();
		for (int i = 1; i <= n; i++) {
			a2[i] = readInt();
		}
		int[][] dp = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if ((s1[i-1] == 'W' && s2[j-1] == 'L' && a1[i] > a2[j]) || (s1[i-1] == 'L' && s2[j-1] == 'W' && a1[i] < a2[j])) {
					dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1] + a1[i] + a2[j]));
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[n][n]);
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
