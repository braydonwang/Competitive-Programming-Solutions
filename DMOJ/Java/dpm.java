import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = (int)(1e9 + 7);
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		long[] dp = new long[k+1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			int num = readInt();
			long[] fake = new long[k+1];
			for (int j = k; j >= 0; j--) {
				long temp = dp[j];
				int l = j+1;
				int r = j + Math.min(num, k-j);
				if (l <= r) {
					fake[l] = add(fake[l],temp);
					if (r + 1 <= k) {
						fake[r+1] = sub(fake[r+1],temp);
					}
				}
			}
			long sum = 0;
			for (int j = 0; j <= k; j++) {
				sum = add(sum,fake[j]);
				dp[j] = add(dp[j],sum);
			}
		}
		System.out.println(dp[k]);
	}
	static long add(long a, long b) {
		a += b;
		if (a >= mod) {
			a -= mod;
		}
		return a;
	}
	static long sub(long a, long b) {
		a -= b;
		if (a < 0) {
			a += mod;
		}
		return a;
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
