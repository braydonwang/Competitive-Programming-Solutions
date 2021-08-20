import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		while (true) {
			int n = readInt();
			if (n == 0) {
				break;
			}
			int[][] a = new int[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					a[i][j] = readInt();
				}
			}
			boolean good = true;
			for (int i = 1; i <= n; i++) {
				for (int j = i+1; j <= n; j++) {
					for (int k = j+1; k <= n; k++) {
						if (a[i][a[j][k]] != a[a[i][j]][k]) {
							good = false;
							break;
						}
					}
					if (!good) {
						break;
					}
				}
				if (!good) {
					break;
				}
			}
			if (!good) {
				System.out.println("no");
				continue;
			}
			for (int i = 1; i <= n; i++) {
				good = true;
				for (int j = 1; j <= n; j++) {
					if (a[i][j] != j || a[j][i] != j) {
						good = false;
						break;
					}
				}
				if (good) {
					int count = 0;
					for (int j = 1; j <= n; j++) {
						for (int k = 1; k <= n; k++) {
							if (a[j][k] == i && a[k][j] == i) {
								count++;
								break;
							}
						}
					}
					if (count == n) {
						good = true;
						System.out.println("yes");
						break;
					}
				}
			}
			if (!good) {
				System.out.println("no");
				continue;
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
