import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n], b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = readInt();
		}
		Arrays.sort(a); Arrays.sort(b);
		long tot = 1;
		for (int i = n-1; i >= 0; i--) {
			int lo = 0, hi = n-1, ans = -1;
			while (lo <= hi) {
				int mid = (lo + hi) / 2;
				if (b[mid] >= a[i]) {
					ans = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			}
			if (ans == -1) {
				continue;
			}
			tot *= (n - ans) - (n-1-i);
		}
		System.out.println(tot);
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
