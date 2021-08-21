import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		long[] pre = new long[n+1];
		for (int i = 1; i <= n; i++) {
			pre[i] = readInt() + pre[i-1];
		}
		long min = Long.MAX_VALUE;
		for (int l = 2; l < n; l++) {
			long t1 = pre[l-1];
			int lo = l, hi = n-1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				long t2 = pre[mid] - pre[l-1], t3 = pre[n] - pre[mid];
				long small = Math.min(t1, Math.min(t2, t3));
				long large = Math.max(t1, Math.max(t2, t3));
				min = Math.min(min, large-small);
				if (t2 > t3) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
		}
		System.out.println(min);
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
