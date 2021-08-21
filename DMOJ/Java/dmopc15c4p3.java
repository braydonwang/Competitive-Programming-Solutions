import java.util.*;
import java.io.*;
public class Template {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean good;
	static int p, t;
	static int sum;
	public static void main(String[] args) throws IOException {
		int g = readInt();
		for (int i = 0; i < g; i++) {
			int n = readInt();
			int[] array = new int[n];
			sum = 0;
			for (int j = 0; j < n; j++) {
				array[j] = readInt();
				sum += array[j];
			}
			p = readInt(); t = readInt();
			if (sum < p + t) {
				System.out.println("NOT LETHAL");
				continue;
			}
			boolean[] dp = new boolean[sum+1];
			dp[0] = true;
			for (int j = 0; j < n; j++) {
				for (int k = sum; k >= array[j]; k--) {
					if (dp[k-array[j]]) {
						dp[k] = true;
					}
				}
			}
			boolean good = false;
			for (int j = t; j <= sum; j++) {
				if (dp[j]) {
					if (sum - j >= p) {
						System.out.println("LETHAL");
						good = true;
						break;
					}
				}
			}
			if (!good) {
				System.out.println("NOT LETHAL");
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
