import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = readInt();
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			int t1 = 0, t2 = 0;
			for (int j = 0; j < n; j++) {
				if (j % 2 == 0) {
					t1 += a[i][j];
				} else {
					t2 += a[i][j];
				}
			}
			max += Math.max(t1, t2);
		}
		int max2 = 0;
		for (int i = 0; i < n; i++) {
			int t1 = 0, t2 = 0;
			for (int j = 0; j < n; j++) {
				if (j % 2 == 0) {
					t1 += a[j][i];
				} else {
					t2 += a[j][i];
				}
			}
			max2 += Math.max(t1, t2);
		}
		System.out.println(Math.max(max, max2));
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
