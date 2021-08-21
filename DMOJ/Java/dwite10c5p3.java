import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 5; i++) {
			int n = readInt();
			int sum = 0;
			int[] array = new int[n];
			for (int j = 0; j < n; j++) {
				array[j] = readInt();
				sum += array[j];
			}
			boolean[][] dp = new boolean[n+1][sum+1];
			for (int j = 0; j <= n; j++) {
				dp[j][0] = true;
			}
			for (int j = 1; j <= sum; j++) {
				dp[0][j] = false;
			}
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= sum; k++) {
					dp[j][k] = dp[j-1][k];
					if (array[j-1] <= k) {
						dp[j][k] |= dp[j-1][k-array[j-1]];
					}
				}
			}
			for (int j = sum/2; j >= 0; j--) {
				if (dp[n][j]) {
					System.out.println(sum - 2*j);
					break;
				}
			}
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
