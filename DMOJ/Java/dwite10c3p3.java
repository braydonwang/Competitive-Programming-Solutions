import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int mod = (int) 1e6;
		for (int a = 0; a < 5; a++) {
			int n = readInt();
			if (n % 2 != 0) {
				System.out.println(0);
				continue;
			}
			int[] dp = new int[n+1];
			dp[0] = 1;
			for (int i = 2; i <= n; i+=2) {
				//three ways to fill a 3x2 rectangle with 2x1blocks
				dp[i] += (dp[i-2] * 3) % mod;
				for (int k = 4; i-k >= 0; k+=2) {
					//two ways to fill a 3x4 rectangle with two vertical dominoes on each side
					dp[i] += (dp[i-k] * 2) % mod;
				}
			}
			System.out.println(dp[n] % mod);
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
