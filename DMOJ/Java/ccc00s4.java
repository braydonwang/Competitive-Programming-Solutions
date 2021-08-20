import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), x = readInt();
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < x; i++) {
			int a = readInt();
			for (int j = 0; j <= n; j++) {
				if (j + a <= n && dp[j] != Integer.MAX_VALUE && dp[j] + 1 < dp[j+a]) {
					dp[j+a] = dp[j] + 1;
				}
			}
		}
		if (dp[n] != Integer.MAX_VALUE) {
			System.out.println("Roberta wins in " + dp[n] + " strokes.");
		} else {
			System.out.println("Roberta acknowledges defeat.");
		}
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
