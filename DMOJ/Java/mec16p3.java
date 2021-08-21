import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), T = readInt(), dp[][] = new int[n+1][T+1];
		for (int i = 1; i <= n; i++) {
			int lvl = readInt(), t = 0, val = 0;
			for (int j = 1; j <= lvl; j++) {
				t += readInt(); val += readInt();
				for (int k = 0; k <= T; k++) {
					dp[i][k] = Math.max(dp[i][k],dp[i-1][k]);
					if (k >= t) {
						dp[i][k] = Math.max(dp[i][k], dp[i-1][k-t] + val);
					}
				}
			}
		}
		System.out.println(dp[n][T]);
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
