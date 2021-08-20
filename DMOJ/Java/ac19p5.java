import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp, array;
	static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		array = new int[n][n]; dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				array[i][j] = readInt();
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(solve(i,j) + 1, max);
			}
		}
		System.out.println(max-1);
	}
	static int solve(int i, int j) {
		if (dp[i][j] > 0) {
			return dp[i][j];
		}
		int m = 0;
		for (int k = 0; k < 4; k++) {
			int newi = i + direction[k][0], newj = j + direction[k][1];
			if (newi >= 0 && newi < n && newj >= 0 && newj < n && array[newi][newj] > array[i][j]) {
				m = Math.max(m, solve(newi,newj) + 1);
			}
		}
		return dp[i][j] = m;
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
