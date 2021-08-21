import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		long[][] dp = new long[1 << n][n];
		for (int i = 0; i < n; i++) {
			dp[1 << i][i] = 1;
		}
		long ans = 0;
		for (int mask = 1; mask < (1 << n); mask++) {
			for (int i = 0; i < n; i++) {
				if ((mask & (1 << i)) != 0) {
					for (int j = 0; j < n; j++) {
						if ((mask & (1 << j)) == 0 && Math.abs(array[i] - array[j]) > k) {
							dp[mask | (1 << j)][j] += dp[mask][i];
						}
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			ans += dp[(1 << n) - 1][i];
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
