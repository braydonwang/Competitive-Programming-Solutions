import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), t = readInt();
		int[] array = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			sum += array[i];
		}
		int[] dp = new int[sum+1];
		if (sum < t) {
			System.out.println(-1);
		}
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = sum; j >= array[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-array[i]]);
			}
		}
		for (int i = t; i <= sum; i++) {
			if (dp[i] == 1) {
				System.out.println(i-t);
				break;
			}
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
