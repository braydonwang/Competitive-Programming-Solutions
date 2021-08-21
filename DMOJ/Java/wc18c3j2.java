import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		Arrays.sort(a);
		int lo = 0, hi = n-1, ans = -1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] <= 100) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		if (ans == -1) {
			System.out.println(0);
		} else if (ans == 0) {
			System.out.println(a[ans]);
		} else {
			System.out.println(a[ans] + a[ans-1]);
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
