import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), H = readInt();
		long[] dp = new long[H+1];
		long[] pre = new long[H+1];
		for (int i = 0; i < n; i++) {
			int g = readInt(), h = readInt(), q = readInt(), t = readInt();
			for (int j = h; j <= H; j++) {
				dp[j] = pre[j-h] + g;
			}
			for (int j = h+t; j <= H; j++) {
				dp[j] = Math.max(dp[j], dp[j-t]+q);
			}
			for (int j = 0; j <= H; j++) {
				dp[j] = Math.max(dp[j], pre[j]);
			}
			for (int j = 0; j <= H; j++) {
				pre[j] = dp[j];
			}
		}
		System.out.println(dp[H]);
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
