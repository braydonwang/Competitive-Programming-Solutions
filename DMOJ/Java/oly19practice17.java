import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int max = 0;
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			max = Math.max(array[i], max);
		}
		int[] freq = new int[max+1];
		for (int i = 0; i < n; i++) {
			freq[array[i]]++;
		}
		int[] dp = new int[max+1];
		for (int i = 1; i <= max; i++) {
			dp[i] = freq[i] * i;
		}
		for (int i = 2; i <= max; i++) {
			dp[i] = Math.max(dp[i] + dp[i-2], dp[i-1]);
		}
		System.out.println(dp[max]);
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
