import java.util.*;
import java.io.*;
public class CCC2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		long[] array = new long[n];
		for (int i = 0; i < n; i++) {
			long x = readLong(), y = readLong();
			array[i] = x*x + y*y;
		}
		Arrays.sort(array);
		for (int i = 0; i < q; i++) {
			long r = readLong();
			r = r*r;
			int lo = 0, hi = n-1;
			while(lo <= hi) {
				int mid = (lo + hi) / 2;
				if (array[mid] <= r) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
			System.out.println(lo);
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
