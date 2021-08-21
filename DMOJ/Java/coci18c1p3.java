import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a1, a2;
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		a1 = new int[Math.max(n, m)]; a2 = new int[Math.min(n, m)];
		if (n < m) {
		    for (int i = 0; i < n; i++) {
				a2[i] = readInt();
			}
			for (int i = 0; i < m; i++) {
				a1[i] = readInt();
			}
		} else {
			for (int i = 0; i < n; i++) {
				a1[i] = readInt();
			}
			for (int i = 0; i < m; i++) {
				a2[i] = readInt();
			}
		}
		Arrays.sort(a1); Arrays.sort(a2);
		int lo = 0, hi = (int)1e9, ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (solve(mid)) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		System.out.println(ans);
	}
	static boolean solve(int dif) {
		int ind = 0;
		for (int i = 0; i < a2.length; i++) {
			for (; ind <= a1.length; ind++) {
				if (ind == a1.length) {
					return false;
				}
				if (Math.abs(a1[ind] - a2[i]) <= dif) {
					break;
				}
			}
			ind++;
		}
		return true;
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
