import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] v = new int[n], w = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int a = readInt(), b = readInt();
			v[i] = b; sum += b;
			w[i] = (int)Math.ceil((a+1)/2.0);
		}
		long[] dp = new long[sum+1];
		Arrays.fill(dp, (long)1e12);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = sum; j >= v[i]; j--) {
				dp[j] = Math.min(dp[j], dp[j - v[i]] + w[i]);
			}
		}
		long min = Long.MAX_VALUE;
		for (int i = (sum+2)/2; i <= sum; i++) {
			min = Math.min(min, dp[i]);
		}
		System.out.println(min);
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
