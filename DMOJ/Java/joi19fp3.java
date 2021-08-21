import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int max = 203;
	public static void main(String[] args) throws IOException {
		int n = readInt(), len = readInt();
		int[] x = new int[max], t = new int[max];
		int[][][][] dp = new int[max][max][max][2];
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				for (int k = 0; k < max; k++) {
					dp[i][j][k][0] = dp[i][j][k][1] = (int)1e9;
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			x[i] = readInt();
		}
		for (int i = 1; i <= n; i++) {
			t[i] = readInt();
		}
		dp[n+1][0][0][0] = 0; x[n+1] = len;
		for (int l = n+1; l >= 1; l--) {
			for (int r = 0; r < l; r++) {
				for (int k = 0; k <= n - (l-r) + 1; k++) {
					int time = Math.min(dp[l][r][k][0] + (x[l] - x[l-1]), dp[l][r][k][1] + (len - x[l-1] + x[r]));
					dp[l-1][r][k][0] = Math.min(time, dp[l-1][r][k][0]);
					if (time <= t[l-1]) {
						dp[l-1][r][k+1][0] = Math.min(time, dp[l-1][r][k+1][0]);
					}
					time = Math.min(dp[l][r][k][0] + (len - x[l] + x[r+1]), dp[l][r][k][1] + (x[r+1] - x[r]));
					dp[l][r+1][k][1] = Math.min(dp[l][r+1][k][1],time);
					if (time <= t[r+1]) {
						dp[l][r+1][k+1][1] = Math.min(dp[l][r+1][k+1][1],time);
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int l = n+1; l >= 1; l--) {
			for (int r = 0; r < l; r++) {
				for (int k = 0; k <= n; k++) {
					if (dp[l][r][k][0] != 1e9 || dp[l][r][k][1] != 1e9) {
						max = Math.max(max, k);
					}
				}
			}
		}
		System.out.println(max);
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
