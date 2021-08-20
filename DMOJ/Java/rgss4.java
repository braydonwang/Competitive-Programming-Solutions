import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n+1];
		for (int i = 1; i <= n; i++) {
			array[i] = readInt();
		}
		int[] dp = new int[n+1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			dp[i] = array[i];
			for (int j = 1; j < i; j++) {
				if (array[j] < array[i]) {
					dp[i] = Math.max(dp[i], dp[j] + array[i]);
				}
			}
			max = Math.max(dp[i], max);
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
