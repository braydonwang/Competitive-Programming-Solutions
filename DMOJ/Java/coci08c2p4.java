import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		n = readInt();
		int[] a = new int[n], b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt(); b[i] = readInt();
		}
		m = readInt();
		int[] c = new int[m], d = new int[m];
		for (int i = 0; i < m; i++) {
			c[i] = readInt(); d[i] = readInt();
		}
		int lo = 0, hi = t, ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (solve(a,b,c,d,mid,t)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static boolean solve(int[] a, int[] b, int[] c, int[] d, int mid, int t) {
		int v = mid, w = t-mid;
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < n; i++) {
			if (v < a[i]) {
				continue;
			}
			cnt1 += (v-a[i]) / b[i] + 1;
		}
		for (int i = 0; i < m; i++) {
			if (w < c[i]) {
				continue;
			}
			cnt2 += (w-c[i]) / d[i] + 1;
		}
		if (cnt1 <= cnt2) {
			return true;
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
