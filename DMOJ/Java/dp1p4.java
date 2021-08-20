import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int mod = 10007;
	public static void main(String[] args) throws IOException {
		String str = next();
		int n = str.length();
		long[] dp = new long[n+1];
		int[] last = new int[26];
		Arrays.fill(last, -1);
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i] = 2*dp[i-1];
			if (last[str.charAt(i-1)-'a'] != -1) {
				dp[i] = (dp[i] - dp[last[str.charAt(i-1)-'a']]) % mod;
			}
			last[str.charAt(i-1)-'a'] = i-1;
		}
		System.out.println(dp[n] % mod - 1);
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
