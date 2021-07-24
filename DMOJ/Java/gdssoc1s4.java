import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[][][] bit;
	static int[][][] array;
	static int n;
	public static void main(String[] args) throws IOException {
		n = readInt();
		array = new int[n+1][n+1][n+1];
		int q = readInt();
		bit = new long[n+1][n+1][n+1];
		long ans = 0;
		for (int i = 0; i < q; i++) {
			char ch = readCharacter();
			if (ch == 'C') {
				int x = readInt(), y = readInt(), z = readInt(), l = readInt();
				update(x,y,z,l-array[z][y][x]);
				array[z][y][x] = l;
			} else {
				int x1 = readInt(), y1 = readInt(), z1 = readInt(), x2 = readInt(), y2 = readInt(), z2 = readInt();
				ans += query(x2,y2,z2) - query(x1-1,y2,z2) - query(x2,y1-1,z2) - query(x2,y2,z1-1) + query(x1-1,y1-1,z2) + query(x1-1,y2,z1-1) + query(x2,y1-1,z1-1) - query(x1-1,y1-1,z1-1);
			}
		}
		System.out.println(ans);
	}
	static void update(int x, int y, int z, int val) {
		for (int i = z; i <= n; i += i & -i) {
			for (int j = y; j <= n; j += j & -j) {
				for (int k = x; k <= n; k += k & -k) {
					bit[i][j][k] += val;
				}
			}
		}
	}
	static long query(int x, int y, int z) {
		long sum = 0;
		for (int i = z; i > 0; i -= i & -i) {
			for (int j = y; j > 0; j -= j & -j) {
				for (int k = x; k > 0; k -= k & -k) {
					sum += bit[i][j][k];
				}
			}
		}
		return sum;
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
