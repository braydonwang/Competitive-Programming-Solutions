import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		long[] a = new long[n], b = new long[n], c = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt(); b[i] = readInt(); c[i] = readInt();
		}
		long ans = Long.MIN_VALUE;
		int[] d = new int[m], f = new int[m];
		for (int i = 0; i < m; i++) {
			d[i] = readInt(); f[i] = readInt();
		}
		long[] dp = new long[5001];
		for (int j = 0; j < n; j++) {
			long temp = a[j];
			for (int k = 1; k <= temp; k *= 2) {
				for (int l = 5000; l >= b[j]*k; l--) {
					dp[l] = Math.max(dp[l], dp[(int) (l - b[j]*k)] + c[j]*k);
				}
				temp -= k;
			}
			if (temp > 0) {
				for (int k = 5000; k >= b[j]*temp; k--) {
					dp[k] = Math.max(dp[k], dp[(int) (k-b[j]*temp)] + c[j]*temp);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			ans = Math.max(ans, dp[d[i]] - f[i]);
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
