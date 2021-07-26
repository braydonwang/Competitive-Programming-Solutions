import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int m = readInt(), u = readInt(), r = readInt();
		int[] v = new int[r], t = new int[r], f = new int[r];
		for (int i = 0; i < r; i++) {
			v[i] = readInt(); t[i] = readInt(); f[i] = readInt();
		}
		int[][] dp = new int[m+1][u+1];
		for (int i = 0; i < r; i++) {
			for (int j = m; j >= t[i]; j--) {
				for (int k = u; k >= f[i]; k--) {
					dp[j][k] = Math.max(dp[j][k], dp[j-t[i]][k-f[i]] + v[i]);
				}
			}
		}
		System.out.println(dp[m][u]);
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
