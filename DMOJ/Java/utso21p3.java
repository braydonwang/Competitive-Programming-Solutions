import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), mod = (int)1e9+7;
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			a[i] = readInt();
		}
		int[] dp = new int[n+1];
		dp[0] = 1; dp[1] = 1;
		int max = a[1], pre = 2;
		for (int i = 2; i <= n; i++) {
			max = Math.max(max, a[i]);
			if (a[i] == max) {
				dp[i] = pre;
			} else {
				dp[i] = dp[i-1];
			}
			pre = (pre + dp[i]) % mod;
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
