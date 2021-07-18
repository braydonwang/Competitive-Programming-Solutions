import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		Arrays.sort(a);
		HashSet<Integer> set = new HashSet<Integer>();
		boolean[][] dp = new boolean[n][25001];
		dp[0][0] = true; 
		int count = 1, vol = a[n-1]*n;
		for (int i = n-2; i >= 0; i--) {
			for (int j = 0; j <= vol; j++) {
				dp[count][j] = dp[count-1][j];
			}
			for (int x: set) {
				int dif = Math.abs(a[i] - x);
				for (int j = dif; j <= vol; j++) {
					dp[count][j] |= dp[count-1][j-dif];
				}
			}
			count++; set.add(a[i]);
		}
		for (int i = 0; i <= 25000; i++) {
			if (dp[n-1][i]) {
				System.out.print(i + " ");
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
