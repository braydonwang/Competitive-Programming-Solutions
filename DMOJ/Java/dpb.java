import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] dp = new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[1] = 0;
		int[] h = new int[n+1];
		for (int i = 1; i <= n; i++) {
			h[i] = readInt();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i + j <= n) {
					dp[i+j] = Math.min(dp[i+j], Math.abs(h[i]-h[i+j]) + dp[i]);
				}
			}
		}
		System.out.println(dp[n]);
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
