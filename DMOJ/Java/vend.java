import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		long[] dp = new long[t+1];
		for (int i = 0; i < n; i++) {
			int a = readInt(), b = readInt(), c = readInt(), d = readInt();
			int sum = a+c, val = b+d;
			for (int j = sum; j <= t; j++) {
				dp[j] = Math.max(dp[j], dp[j-sum] + val);
			}
			for (int j = t; j >= a; j--) {
				dp[j] = Math.max(dp[j],dp[j-a] + b);
			}
			for (int j = t; j >= c; j--) {
				dp[j] = Math.max(dp[j],dp[j-c] + d);
			}
		}
		System.out.println(dp[t]);
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
