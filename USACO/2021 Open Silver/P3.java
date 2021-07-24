import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k, l;
	static int[] a;
	public static void main(String[] args) throws IOException {
		n = readInt(); k = readInt(); l = readInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		Arrays.sort(a);
		int lo = 0, hi = n, ans = 0;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (check(mid)) {
				lo = mid + 1;
				ans = mid;
			} else {
				hi = mid - 1;
			}
		}
		System.out.println(ans);
	}
	static boolean check(int x) {
		long area = 0;
		for (int i = n-1; i >= n-x; i--) {
			if (a[i] < x) {
				area += x - a[i];
				if (a[i] + k < x) {
					return false;
				}
			}
		}
		return area <= (long)k*l;
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
