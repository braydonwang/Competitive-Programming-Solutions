import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = 0;
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = readInt();
			}
		}
		boolean[] r = new boolean[n], c = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (a[0][i] == 1) {
				c[i] = true;
				m++;
			}
		}
		for (int i = 1; i < n; i++) {
			if (c[0]) {
				if (a[i][0] == 0) {
					r[i] = true;
					m++;
				}
			} else {
				if (a[i][0] == 1) {
					r[i] = true;
					m++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[j] != r[i]) {
					if (a[i][j] == 0) {
						System.out.println(-1);
						return;
					}
				} else {
					if (a[i][j] == 1) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(m);
		for (int i = 0; i < n; i++) {
			if (r[i]) {
				System.out.println("R " + (i+1));
			}
		}
		for (int i = 0; i < n; i++) {
			if (c[i]) {
				System.out.println("C " + (i+1));
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
