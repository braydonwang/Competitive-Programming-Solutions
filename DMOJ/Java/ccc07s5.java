import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int z = readInt();
		for (int a = 0; a < z; a++) {
			int n = readInt(), k = readInt(), w = readInt();
			int[][] dp = new int[k+1][n+1];
			int[] pre = new int[n+1];
			//Prefix sum array
			for (int i = 1; i <= n; i++) {
				pre[i] = readInt() + pre[i-1];
			}
			//Loop through the number of bowling balls
			for (int i = 1; i <= k; i++) {
				//Loop through the number of pins
				for (int j = 1; j <= n; j++) {
					//if there are not enough pins to hold a width of w, just add all
					if (j <= w) {
						dp[i][j] = pre[j];
					//else, take the sum of the pins from j to j-w and find the max of that sum + the max value
					//with one less throw and all the pins to the left of j-w or take the previous max value
					//using all the pins from j-1 to the left
					} else {
						dp[i][j] = pre[j] - pre[j-w];
						dp[i][j] = Math.max(dp[i-1][j-w] + dp[i][j], dp[i][j-1]);
					}
				}
			}
			System.out.println(dp[k][n]);
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
