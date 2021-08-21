import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		int max = (int) 1e6;
		int[] dp = new int[max+1];
		Arrays.fill(dp, (int)1e9);
		dp[0] = 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int a = readInt(), b = readInt();
			for (int j = a; j <= max; j++) {
				if (dp[j-a] != -1) {
					dp[j] = Math.min(dp[j], dp[j-a] + b);
					if (j >= m) {
						ans = Math.min(dp[j], ans);
					}
				}
			}
		}
		System.out.println(ans);
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
