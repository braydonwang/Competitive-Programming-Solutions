import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] bit;
	static int m, n;
	public static void main(String[] args) throws IOException {
		m = readInt(); n = readInt();
		bit = new int[m+1][n+1];
		int[][] array = new int[m+1][n+1];
		while (true) {
			int temp = readInt();
			if (temp == 0) {
				break;
			}
			if (temp == 1) {
				int r = readInt(), c = readInt(), x = readInt();
				int hi = x;
				x = x - array[r][c];
				if (r == 0 && c == 0 && x == 0) {
					break;
				}
				if (r % 2 == 0 && c % 2 == 0) {
					update(c,r,x);
				} else if (r % 2 != 0 && c % 2 == 0) {
					update(c,r,-x);
				} else if (r % 2 != 0 && c % 2 != 0) {
					update(c,r,x);
				} else {
					update(c,r,-x);
				}
				array[r][c] = hi;
			} else {
				int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
				if (r1 == 0 && c1 == 0 && r2 == 0 && c2 == 0) {
					break;
				}
				long a = query(c2,r2) - query(c1-1,r2) - query(c2,r1-1) + query(c1-1,r1-1);
				if (r1 % 2 == c1 % 2) {
					System.out.println(a);
				} else {
					System.out.println(-a);
				}
			}
		}
	}
	static void update(int x, int y, int val) {
		for (int i = y; i <= m; i += i & -i) {
			for (int j = x; j <= n; j += j & -j) {
				bit[i][j] += val;
			}
		}
	}
	static long query(int x, int y) {
		long total = 0;
		for (int i = y; i > 0; i -= i & -i) {
			for (int j = x; j > 0; j -= j & -j) {
				total += bit[i][j];
			}
		}
		return total;
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
