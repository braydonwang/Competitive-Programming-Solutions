import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		int lim = 9500;
		int[] s = new int[n], u = new int[n];
		int[] dp = new int[lim], dp2 = new int[lim];
		Arrays.fill(dp, (int) 1e9);
		Arrays.fill(dp2, (int) 1e9);
		dp[0] = 0;
		dp2[0] = 0;
		for (int i = 0; i < n; i++) {
			s[i] = readInt();
		}
		for (int i = 0; i < n; i++) {
			u[i] = readInt();
			u[i] = Math.min(u[i], lim/s[i]);
		}
		int min = (int)1e9;
		for (int i = 0; i < n; i++) {
			int temp = 0;
			for (int j = 0; j < u[i]; j++) {
				temp += s[i];
				for (int k = lim-1; k >= temp; k--) {
					dp[k] = Math.min(dp[k], dp[k-s[i]] + 1);
				}
			}
			for (int k = s[i]; k < lim; k++) {
				dp2[k] = Math.min(dp2[k], dp2[k-s[i]] + 1);
			}
		}
		for (int i = t; i < lim; i++) {
			int j = i - t;
			min = Math.min(min, dp[i] + dp2[j]);
		}
		System.out.println(min == 1e9 ? -1 : min);
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
