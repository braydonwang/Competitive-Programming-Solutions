import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] array = new int[n];
		int total = 0;
		for (int i = 0; i < n; i++) {
			array[i] = readInt();
			total += array[i];
		}
		int[] dp = new int[total+1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = total; j >= 0; j--) {
				if (j >= array[i] && dp[j-array[i]] == 1) {
					dp[j] = 1;
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= total; i++) {
			if (dp[i] == 1) {
				ans = Math.min(ans, Math.abs(i-(total-i)));
			}
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
