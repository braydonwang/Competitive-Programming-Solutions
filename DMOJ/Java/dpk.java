import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp;
	static int n;
	static int[] a;
	public static void main(String[] args) throws IOException {
		n = readInt(); int k = readInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		dp = new int[k+1][2];
		for (int i = 0; i <= k; i++) {
			dp[i][0] = dp[i][1] = -1;
		}
		System.out.println(solve(k,0) == 0 ? "First" : "Second");
	}
	static int solve(int k, int ind) {
		if (dp[k][ind] != -1) {
			return dp[k][ind];
		}
		boolean good = false;
		for (int i = 0; i < n; i++) {
			if (a[i] > k) {
				break;
			}
			if (solve(k-a[i],(ind+1)%2) == ind) {
				good = true;
				break;
			}
		}
		if (good) {
			return dp[k][ind] = ind;
		} else {
			return dp[k][ind] = (ind+1) % 2;
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
