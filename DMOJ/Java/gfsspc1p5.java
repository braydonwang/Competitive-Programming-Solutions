import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		int[] array = new int[n+1];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
		}
		array[n] = 0;
		int ind = 0;
		Arrays.sort(array);
		for (int i = 0; i <= n; i++) {
			if (array[i] == 0) {
				ind = i;
				break;
			}
		}
		int[][][] dp = new int[n+1][n+1][2];
		int min = Integer.MAX_VALUE;
		for (int l = n; l >= 0; l--) {
			for (int r = l; r <= n; r++) {
				if (l == r) {
					dp[l][r][0] = dp[l][r][1] = Math.abs(array[l]);
					continue;
				}
				dp[l][r][0] = Math.min(dp[l+1][r][0] + (array[l+1] - array[l]), dp[l+1][r][1] + (array[r] - array[l]));
				dp[l][r][1] = Math.min(dp[l][r-1][0] + (array[r] - array[l]), dp[l][r-1][1] + (array[r] - array[r-1]));
				if (r - l == t) {
					min = Math.min(min, Math.min(dp[l][r][0], dp[l][r][1]));
				}
			}
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
