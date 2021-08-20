import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for (int a = 0; a < t; a++) {
			int l = readInt(), n = readInt();
			long[] pre = new long[l+1];
			for (int i = 0; i < n; i++) {
				int c = readInt(), r = readInt(), d = readInt();
				pre[Math.max(c-r,1)] += d;
				if (c + r + 1 <= l) {
					pre[c+r+1] -= d;
				}
			}
			for (int i = 1; i <= l; i++) {
				pre[i] += pre[i-1];
			}
			for (int i = 1; i <= l; i++) {
				pre[i] += pre[i-1];
			}
			int m = readInt();
			for (int i = 0; i < m; i++) {
				int h = readInt();
				int lo = 1, hi = l, ans = -1;
				while (lo <= hi) {
					int mid = (lo + hi) / 2;
					if (pre[mid] < h) {
						lo = mid + 1;
					} else {
						ans = mid;
						hi = mid - 1;
					}
				}
				if (ans == -1) {
					System.out.println("Bloon leakage");
				} else {
					System.out.println(ans);
				}
			}
		}
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
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
