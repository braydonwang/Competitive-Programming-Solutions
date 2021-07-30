import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int i = 0; i < t; i++) {
			int m = readInt();
			int[][] a = new int[2][m+1];
			for (int j = 0; j < 2; j++) {
				for (int k = 1; k <= m; k++) {
					a[j][k] = readInt();
				}
			}
			for (int j = 1; j <= m; j++) {
				a[0][j] += a[0][j-1];
				a[1][j] += a[1][j-1];
			}
			int ans = Integer.MAX_VALUE;
			for (int j = 1; j <= m; j++) {
				ans = Math.min(ans, Math.max(a[1][j-1], a[0][m] - a[0][j]));
			}
			System.out.println(ans);
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
