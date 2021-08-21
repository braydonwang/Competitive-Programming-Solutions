import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int count = 1;
		while (true) {
			int n = readInt();
			if (n == 0) {
				break;
			}
			int[] array = new int[n+1];
			for (int i = 1; i <= n; i++) {
				array[i] = readInt();
			}
			int[][] dp = new int[n+1][n+1];
			int temp = n % 2;
			for (int l = n; l >= 1; l--) {
				for (int r = l; r <= n; r++) {
					if ((r - l + 1) % 2 == temp) {
						if (l == r) {
							dp[l][r] = array[l];
						} else {
							dp[l][r] = Math.max(array[l] + dp[l+1][r], array[r] + dp[l][r-1]);
						}
					} else {
						if (l == r) {
							dp[l][r] = -array[l];
						} else {
							if (array[r] > array[l]) {
								dp[l][r] = dp[l][r-1] - array[r];
							} else {
								dp[l][r] = dp[l+1][r] - array[l];
							}
						}
					}
					//System.out.println(dp[l][r] + " " + l + " " + r);
				}
			}
			System.out.println("In game " +  count + ", the greedy strategy might lose by as many as " + dp[1][n] + " points.");
			count++;
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
