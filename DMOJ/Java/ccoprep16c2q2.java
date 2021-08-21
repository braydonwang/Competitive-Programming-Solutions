import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] dp = new int[n];
		int[] temp = new int[30];
		int max = 0;
		Arrays.fill(temp, -1);
		for (int i = 0; i < n; i++) {
			int num = readInt();
			dp[i] = 1;
			for (int j = 0; num != 0; num = num >> 1, j++) {
				if ((num & 1) == 1) {
					if (temp[j] != -1) {
						dp[i] = Math.max(dp[i], dp[temp[j]] + 1);
					}
					temp[j] = i;
				}
			}
			max = Math.max(max, dp[i]);
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
