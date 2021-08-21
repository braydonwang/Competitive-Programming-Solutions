import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		int n = readInt(), w = readInt();
		int[] dp = new int[w+1];
		for (int i = 0; i < n; i++) {
			int p0 = readInt(), v0 = readInt(), p1 = readInt(), v1 = readInt(), p2 = readInt(), v2 = readInt();
			for (int j = w; j >= 1; j--) {
				if (j >= p0) {
					dp[j] = Math.max(dp[j], dp[j-p0]+v0);
				}
				if (j >= p1) {
					dp[j] = Math.max(dp[j], dp[j-p1]+v1);
				}
				if (j >= p2) {
					dp[j] = Math.max(dp[j], dp[j-p2]+v2);
				}
			}
		}
		System.out.println(dp[w]);
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
