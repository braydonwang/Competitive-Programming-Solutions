import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] c, t;
	static int n, m, k;
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt(); k = readInt();
		c = new int[n]; t = new int[m];
		for (int i = 0; i < n; i++) {
			c[i] = readInt();
		}
		for (int i = 0; i < m; i++) {
			t[i] = readInt();
		}
		Arrays.sort(c); Arrays.sort(t);
		int lo = 1, hi = n, ans = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (solve(mid)) {
				hi = mid - 1;
				ans = mid;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(ans);
	}
	static boolean solve(int mid) {
		int j = 0, cnt = 0;
		for (int i = 0; i < m; i++) {
			while (j < n && t[i] <= c[j] && t[i] >= c[j] - k && cnt < mid) {
				j++; cnt++;
			}
			cnt = 0;
			if (j >= n) {
				return true;
			}
		}
		return false;
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
