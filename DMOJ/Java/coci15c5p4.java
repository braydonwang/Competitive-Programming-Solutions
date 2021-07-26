import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long x = readLong();
		long num = (1L*n-1)*(n-2) / 2;
		if (x > num) {
			System.out.println(-1);
			return;
		}
		boolean[] vis = new boolean[n-1];
		System.out.print(n);
		for (int h = 1; h <= n-2; h++) {
			int temp = n-1-h;
			if (x >= temp) {
				x -= temp;
				vis[h] = true;
				System.out.print(" " + h);
			}
			if (x == 0) {
				break;
			}
		}
		System.out.print(" " + (n-1));
		for (int h = n-2; h >= 1; h--) {
			if (!vis[h]) {
				System.out.print(" " + h);
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
